package odysseyUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import odysseyLogic.DocumentoXML;
import odysseyLogic.Node_XML;
import odysseyLogic.ReproductorMp3;
import odysseyLogic.XMLParser;
import odysseyLogic.clientetcp;
import org.w3c.dom.NodeList;

public class Odyssey extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        DocumentoXML n = new DocumentoXML("Comunicacion");
        n.crearHijos("Codigo", "00");
        String msj= n.ejecutar();
        
        
       clientetcp client = new clientetcp();
		java.net.Socket socket = client.crear();
                client.enviar(socket, msj);
                
        
		
		//client.recibir(socket);
                System.out.println(client.getMensajeActual());
                XMLParser NUEVO = new XMLParser();
                String p = NUEVO.DepurarXML(client.getMensajeActual());
                
                System.out.print("Soy el depurado: "+ p);
                Node_XML doc = new Node_XML(NUEVO.parsearString(p));  
                //Base64.Decoder
        
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
 
