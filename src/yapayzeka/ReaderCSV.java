/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehmet
 */
public class ReaderCSV {

    private BufferedReader buffer = null;
    

    public void clearBuffer() throws IOException {

        try {
            this.buffer = new BufferedReader(new FileReader(YapayZekaVeriGiris.getNesne().getDosyaYolu()));
            this.buffer.readLine(); // sutun başlıkları alınmaması için 1 okuma yapıldı
        } catch (FileNotFoundException ex) {
            Logger.getLogger(YapayZekaIslem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getSatir() {
        String line = null;
        try {
            line =  this.buffer.readLine();
        } catch (IOException ex) {
            Logger.getLogger(MinDeger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return line;
    }
}
// ctrl alt f
