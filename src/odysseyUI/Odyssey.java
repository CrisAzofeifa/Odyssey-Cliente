package odysseyUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import odysseyLogic.ConversorMP3_ByteArray;
import org.apache.commons.codec.binary.Base64;
import odysseyLogic.DocumentoXML;
import odysseyLogic.MP3;
import odysseyLogic.Node_XML;
import odysseyLogic.ReproductorMp3;
import odysseyLogic.XMLParser;
import odysseyLogic.clientetcp;
import org.w3c.dom.NodeList;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;


public class Odyssey extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        DocumentoXML n = new DocumentoXML("Comunicacion");
        n.crearHijos("Codigo", "00");
        String msj = n.ConvertirXML_String();
        
        
       clientetcp client = new clientetcp();
		java.net.Socket socket = client.crear();
                client.enviar(socket, msj);
                
        
		
		//client.recibir(socket);
                System.out.println("\n");
                XMLParser NUEVO = new XMLParser();
                //NUEVO.parsearString(client.getMensajeActual());
                //String p = NUEVO.DepurarXML(client.getMensajeActual());
                
                //System.out.print("Soy el depurado: "+ p);
                Node_XML doc = new Node_XML(NUEVO.parsearString(client.getMensajeActual()));  
                NodeList lista = doc.by_tagName("mBytes");
                                
                byte[] decoded = Base64.decodeBase64(lista.item(0).getTextContent().getBytes());
                String ruta = "mp3";
                System.out.println("Soy este base64: " + lista.item(0).getTextContent());
                FileUtils.writeByteArrayToFile(new File("pathname"), decoded);
                               
        
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
 
