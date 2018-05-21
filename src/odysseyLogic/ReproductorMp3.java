/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odysseyLogic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReproductorMp3 extends Thread{
    private String cancion;
    private static ReproductorMp3 instancia;
      
    
    // El constructor es privado, no permite que se genere un constructor por defecto.
    private ReproductorMp3(String ruta) {
        this.cancion = ruta;
    }

    public static ReproductorMp3 getSingletonInstance(String ruta) {
        if (instancia == null){
            instancia = new ReproductorMp3(ruta);
        }
        else{
            System.out.println("No se puede crear el objeto");
            instancia.setRuta(ruta);
        }
        
        return instancia;
    }
    
    
    
    public void reproducir() throws FileNotFoundException,
         JavaLayerException {

      Player apl = new Player(new FileInputStream(
            cancion));

      apl.play();
   }
   @Override
    public void run() {
       try {
           reproducir();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(ReproductorMp3.class.getName()).log(Level.SEVERE, null, ex);
       } catch (JavaLayerException ex) {
           Logger.getLogger(ReproductorMp3.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    private void setRuta(String ruta) {
        this.cancion = ruta;
    }
   
}