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
public class YapayZekaIslem {

    private BufferedReader buffer = null;

    public YapayZekaIslem() {
        this.setBuffer();
    }

    private void setBuffer() {

        try {
            this.buffer = new BufferedReader(new FileReader(YapayZekaVeriGiris.getNesne().getDosyaYolu()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(YapayZekaIslem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private BufferedReader getBuffer() {
        return this.buffer;
    }

    public void degerleriHazirla() {

        int bagimli = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi(); 
        int bagimsiz = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
        
        DegerAralikIslem minList = new MinDeger(bagimli + bagimsiz);
        DegerAralikIslem maxList = new MaxDeger(bagimli + bagimsiz);

        minList.aralikBul();
        maxList.aralikBul();

        Normalizasyon.getNesne().setMaxList(maxList.getDegerArray());
        Normalizasyon.getNesne().setMinList(minList.getDegerArray());
    }

    public void islemBaslat() {
        String line = null;
        try {
            this.buffer.readLine();
            while ((line = this.buffer.readLine()) != null) {
                
                this.yapayZekaDataGonder(ConvertDouble.convert(line.split(";")));
            }
        } catch (IOException ex) {
            Logger.getLogger(MinDeger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void yapayZekaDataGonder(double[] data) {
        
        int bagimli = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi(); 
        int bagimsiz = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
        
        double [] bagimsizDegisken = this.diziKopyala(data, 0, bagimsiz);
        double [] bagimliDegisken = this.diziKopyala(data, bagimsiz ,bagimli);

        YapayZekaNode.getnesne().kararVer(bagimliDegisken, bagimsizDegisken);
        
    }
    private double[] diziKopyala(double[] kopyalanakDizi,int kopyaBaslangicIndex, int yeniDiziUzunluk) {
        
        double[] data = new double[yeniDiziUzunluk];
        System.arraycopy(kopyalanakDizi, kopyaBaslangicIndex, data, 0, yeniDiziUzunluk);
        return data;
                
    }
}
