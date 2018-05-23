package odysseyUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import odysseyLogic.DocumentoXML;
import odysseyLogic.ReproductorMp3;
import odysseyLogic.XMLParser;
import odysseyLogic.clientetcp;

public class Odyssey extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        /*DocumentoXML n = new DocumentoXML("Odyssey");
        n.crearElemento("NuevoUser");
        n.crearHijos("Nombre", "Pedro");
        n.ejecutar();
        */
        
        clientetcp cliente = new clientetcp();
        cliente.start();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
    
