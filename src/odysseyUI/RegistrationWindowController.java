/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odysseyUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import odysseyLogic.DocumentoXML;

/**
 * FXML Controller class
 *
 * @author cris
 */
public class RegistrationWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private CheckBox Rock;

    @FXML
    private CheckBox Electro;

    @FXML
    private CheckBox HipHop;

    @FXML
    private CheckBox Metal;

    @FXML
    private CheckBox Reggaeton;

    @FXML
    private CheckBox Rap;
    
    @FXML
    private TextField UsuarioTextField;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private PasswordField PasswordTextField2;

    @FXML
    private Button VolverBTN;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    void cambiarPaginaLogin(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene creacionDocs = new Scene(gui);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    @FXML
    void registrar(ActionEvent event) throws ParserConfigurationException {
        DocumentoXML nuevo = new DocumentoXML("Registrar");
        nuevo.crearHijos("NombreUsuario", UsuarioTextField.getText());
        nuevo.crearHijos("Contraseña", PasswordTextField.getText());
    }
    public String validarGeneros(){
        String generos = null;  

            
        
        
        
        return generos;
    }  
    
}
