/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odysseyUI;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javazoom.jl.decoder.JavaLayerException;
import odysseyLogic.DocumentoXML;
import odysseyLogic.ReproductorMp3;
import odysseyLogic.clientetcp;


/**
 *
 * @author cris
 */
public class LoginWindowController implements Initializable {
    
    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordTextField;
    
    @FXML
    private Button registrarseBTN;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void cambiarPaginaRegistro(ActionEvent event) throws IOException {        
        System.out.println("odyssey.LoginWindowController.cambiarPaginaRegistro()");
        Parent gui = FXMLLoader.load(getClass().getResource("RegistrationWindow.fxml"));
        Scene creacionDocs = new Scene(gui);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
              
    }
    
    @FXML
    void validarDatos(ActionEvent event) throws IOException, TransformerException, FileNotFoundException, JavaLayerException, ParserConfigurationException {       
        DocumentoXML nuevo = new DocumentoXML("ValidarDatos");
        nuevo.crearHijos("Nombre", userTextField.getText());
        nuevo.crearHijos("Contraseña", passwordTextField.getText());
        nuevo.ejecutar();
        
        Parent gui = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene creacionDocs = new Scene(gui);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
        
    }
    
}
