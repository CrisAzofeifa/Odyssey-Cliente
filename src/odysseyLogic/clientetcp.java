package odysseyLogic;

import java.net.*; 
import java.io.*; 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
 

public class clientetcp {
        private char[] mensajeActual;
    
	public clientetcp(){
		
	}
	
	public java.net.Socket crear() throws UnknownHostException, IOException {
	   String ip = "localhost";
	   int port = 8888;
	   java.net.Socket socket = null;
	
		socket = new java.net.Socket(ip,port);

	return socket;
	   

}
	
	
	 public void cerrar(java.net.Socket socket) throws IOException {
	    	try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			
		}
	    }
	  
	  
    public void enviar(java.net.Socket socket, String msg ) throws IOException, ParserConfigurationException, UnsupportedEncodingException, SAXException, TransformerException {
            
    	OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
    	PrintWriter pw = new PrintWriter(out, true);
		   pw.print(msg);
		   pw.flush();
		   out.write(msg);
		   recibir2(socket);
                   socket.close();
		   
		  
    	
    }
    public void enviarXML(java.net.Socket socket, String msg  ) throws IOException {
    	
    	OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
    	PrintWriter pw = new PrintWriter(out, true);
		   pw.print(msg);
		   pw.flush();
		   out.write(msg);
		   //recibir(socket);
		
    }
     public void recibir(java.net.Socket socket) throws IOException {
    	InputStreamReader in = new InputStreamReader(socket.getInputStream());
    	BufferedReader br = new BufferedReader(in);
		   char[] buffer = new char[99999999];
		   int count = br.read(buffer, 0, 99999999);
		   String reply = new String(buffer, 0, count);
		   System.out.println(reply);

		   
		   
		 
		  /* cerrar(socket);
		   String ip = "localhost";
		   int port = 8888;
		   java.net.Socket socket2 = null;
		   socket2 = new java.net.Socket(ip,port);
		  // enviarXML(socket2, reply);*/
    	
    }
  
    
    
     public void recibir2(java.net.Socket socket) throws IOException, ParserConfigurationException, UnsupportedEncodingException, SAXException, TransformerException   {
        	InputStreamReader in = new InputStreamReader(socket.getInputStream());
        	BufferedReader br = new BufferedReader(in);
    		   char[] buffer = new char[231244+5];
                   int count = br.read(buffer, 0, 231244+5);
    		   String reply = new String(buffer, 0, count);
    		   socket.shutdownOutput();
                   this.mensajeActual = reply;
                   br.close();
    		      	 		   
        	
        }

    public String getMensajeActual() {
        return mensajeActual;
    }
     
}

