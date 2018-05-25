/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odysseyUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import odysseyLogic.Cancion;
import odysseyLogic.ReproductorMp3;

/**
 * FXML Controller class
 *
 * @author cris
 */
public class MainWindowController implements Initializable {
    @FXML
    private TextField userTextField;

    @FXML
    private Button ingresarBTN;

    @FXML
    private Button registrarseBTN;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private ImageView imageLogo;
    
    @FXML
    private Slider sliderCancion;
       
    @FXML
    private ListView<String> listaCanciones;


    private ReproductorMp3 repro = new ReproductorMp3();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void prueba(ActionEvent event) {       
        listaCanciones.getItems().add("Believer  -  Imagine Dragons   -   Deconocido");
                
    } 
    
    @FXML
    void EliminarCancion(ActionEvent event) {
        
    }
    
    @FXML
        void SincronizarDatos(ActionEvent event) {

    }        
    
    @FXML
    void registrarse(ActionEvent event) {
        System.out.println("si sirvo");
    }
    @FXML
        void seleccionDeCancion(ActionEvent event) {
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        //fileChooser.showOpenDialog(window);
        fileChooser.setTitle("Open Resource File");
        System.out.println(selectedFile.getPath());
        
    }
            
    @FXML
    void Pause(ActionEvent event) {
        repro.Pause();
    }

    @FXML
    void Play(ActionEvent event) {
        repro.Play();
    }

    @FXML
    void Resume(ActionEvent event) {
        repro.Resume();
    }

    @FXML
    void Stop(ActionEvent event) {
        repro.Stop();
    }
    
}
