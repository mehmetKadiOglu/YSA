/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.io.IOException;


/**
 *
 * @author mehmet
 */
public class YapayZekaIslem {

    public void islemBaslat() {
        
        ReaderCSV nesne = new ReaderCSV();
        nesne.clearBuffer();
        String line = null;
        
        while( (line = nesne.getSatir()) != null){
            this.yapayZekaDataGonder(ConvertDouble.convert(line.split(";")));
        }
     
    }

    private void yapayZekaDataGonder(double[] data) {
        
        int bagimli = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi(); 
        int bagimsiz = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
        
        double [] bagimsizDegisken = DiziKopyala.islem(data, 0, bagimsiz);
        double [] bagimliDegisken = DiziKopyala.islem(data, bagimsiz ,bagimli);

        YapayZekaNode.getnesne().kararVer(bagimsizDegisken);
        
    }

}
