package odysseyLogic;

import java.net.*; 
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
 

public class clientetcp extends Thread{

   public void server() throws ParserConfigurationException, UnsupportedEncodingException, SAXException, TransformerException
   {
       String ip = "10.42.0.42";
	   int port = 8888;
	   java.net.Socket socket;
	try {
		socket = new java.net.Socket(ip,port);
		OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
		   InputStreamReader in = new InputStreamReader(socket.getInputStream());

		   String msg = "Hello, world!";

		   //send
		   PrintWriter pw = new PrintWriter(out, true);
		   pw.print(msg);
		   pw.flush();
		   // I also tried: out.write(msg); out.flush(); nothing changed

		   //Recibir la respuesta
		   BufferedReader br = new BufferedReader(in);
		   char[] buffer = new char[300];
		   int count = br.read(buffer, 0, 300);
		   String reply = new String(buffer, 0, count);
		   System.out.println(reply);
		   out.write(msg);
		   socket.shutdownOutput();
                   XMLParser parser = new XMLParser();
                   parser.parsearString(reply);
                  
		   try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void run(){
       try {
           server();
       } catch (ParserConfigurationException ex) {
           Logger.getLogger(clientetcp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(clientetcp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SAXException ex) {
           Logger.getLogger(clientetcp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (TransformerException ex) {
           Logger.getLogger(clientetcp.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
}