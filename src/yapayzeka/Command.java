/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author mehmet
 */
public class Command {

    public void verileriAl() {

        YapayZekaVeriGiris.getNesne().bagimliDegiskenSayisiAl();
        YapayZekaVeriGiris.getNesne().bagimsizDegiskenSayisiAl();
        YapayZekaVeriGiris.getNesne().katmanSayisiAl();
        YapayZekaVeriGiris.getNesne().katmanHucreSayilariAl();
        YapayZekaVeriGiris.getNesne().dosyaYoluAl();
        YapayZekaVeriGiris.getNesne().hucreBaglantiSayisiHazirla();
    }
    
    public void normalizeYap(){
        int bagimli = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi(); 
        int bagimsiz = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
        
        DegerAralikIslem minList = new MinDeger(bagimli + bagimsiz);
        DegerAralikIslem maxList = new MaxDeger(bagimli + bagimsiz);

        minList.aralikBul();
        maxList.aralikBul();

        Normalizasyon.getNesne().setMaxList(maxList.getDegerArray());
        Normalizasyon.getNesne().setMinList(minList.getDegerArray());
    }

    public void yapayZekaTahmin() {

        YapayZekaNode.getnesne().katmanHazirla();
        YapayZekaIslem nesne = new YapayZekaIslem();
        try {
            nesne.islemBaslat();
        } catch (IOException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void yapayZekaCiz() {

        int genislik = 140 * (YapayZekaVeriGiris.getNesne().getKatmanSayisi() + 1);
        int yukseklik = 110 * this.enBuyukKatmanHucreSayisi();

        JFrame f = new JFrame("Yapay Zeka Görsel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(genislik, yukseklik);
        f.setVisible(true);

        YapayZekaCiz dc = new YapayZekaCiz((yukseklik / 2) - (5 * 8));
        f.add(dc);
    }

    private int enBuyukKatmanHucreSayisi() {

        int enBuyuk = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
        for (int i = 0; i < YapayZekaVeriGiris.getNesne().getKatmanSayisi(); i++) {
            if (enBuyuk < YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(i)) {
                enBuyuk = YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(i);
            }
        }

        return enBuyuk;

    }

}
