/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import javax.swing.JFrame;

/**
 *
 * @author mehmet
 */
public class Command {

    public void verileriHazirla() {

        YapayZekaVeriGiris.getNesne().bagimliDegiskenSayisiAl();
        YapayZekaVeriGiris.getNesne().bagimsizDegiskenSayisiAl();
        YapayZekaVeriGiris.getNesne().katmanSayisiAl();
        YapayZekaVeriGiris.getNesne().katmanHucreSayilariAl();
        YapayZekaVeriGiris.getNesne().dosyaYoluAl();
        YapayZekaVeriGiris.getNesne().hucreBaglantiSayisiHazirla();
    }

    public void yapayZekaTahmin() {

        YapayZekaNode.getnesne().katmanHazirla();
        YapayZekaIslem nesne = new YapayZekaIslem();
        nesne.degerleriHazirla();
        nesne.islemBaslat();
    }

    public void yapayZekaCiz() {

        int genislik = 140 * (YapayZekaVeriGiris.getNesne().getKatmanSayisi() + 1);
        int yukseklik = 90 * this.enBuyukKatmanHucreSayisi();

        JFrame f = new JFrame("Yapay Zeka Görsel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(genislik, yukseklik);
        f.setVisible(true);

        YapayZekaCiz dc = new YapayZekaCiz((yukseklik / 2) - 5 * 8);
        f.add(dc);
    }

    private int enBuyukKatmanHucreSayisi() {

        int enBuyuk = 0;
        for (int i = 0; i < YapayZekaVeriGiris.getNesne().getKatmanSayisi(); i++) {
            if (enBuyuk < YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(i)) {
                enBuyuk = YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(i);
            }
        }

        return enBuyuk;

    }

}
