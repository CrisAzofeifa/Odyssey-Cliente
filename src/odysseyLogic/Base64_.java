/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odysseyLogic;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 *
 * @author cris
 */
public class Base64_ {
    
    public String cifrarBase64(String a){
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8) );        
        return b;
    }
 
    public String descifrarBase64(String a){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);
 
        String b = new String(decodedByteArray);        
        return b;
    }
}