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

public class ReproductorMp3{
    
    private static ReproductorMp3 instancia;
    public static ReproductorMp3 getSingletonInstance() {
        if (instancia == null){
            instancia = new ReproductorMp3();
        }
        else{
            System.out.println("No se puede crear el objeto");
            
        }
        return instancia;
        
    }
}
    
  