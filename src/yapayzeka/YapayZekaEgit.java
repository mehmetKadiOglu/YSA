/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehmet
 */
public class YapayZekaEgit {

    private final double OGRENME_KATSAYİSİ = 0.10;
    private final double HATA_ESIGI = 0.10;
    private double hataToplami = 0.0;
   // private List<List<Double>> cikisList = null;
    private List<List<Double>> girisList = null;

    public YapayZekaEgit() {
        this.cikisList = new ArrayList<List<Double>>();
        this.girisList = new ArrayList<List<Double>>();
        this.listeOlustur();
    }

    private void listeOlustur() {
        Katman katmanNesne = YapayZekaNode.getnesne().getIlkKatman();
        for (int parentIndex = 0; (katmanNesne != null); parentIndex++, katmanNesne = katmanNesne.sonrakiKatman) {
            girisList.add(new ArrayList<Double>());
          /*  cikisList.add(new ArrayList<Double>());

            for (int index = 0; index < katmanNesne.getHucreListSize(); index++) {
                cikisList.get(parentIndex).add(0.0);
            }*/

            for (int i = 0; i < katmanNesne.getHucreAgirlikSize(); i++) {
                girisList.get(parentIndex).add(0.0);
            }
        }
    }

    public double getHataOrani() {

        return this.hataToplami;
    }

    public void setHataOrani(double fark) {
        this.hataToplami = this.hataToplami + ((Math.pow(fark, 2)) / 2);
    }

    private void setGirisList(double[] data, int parentIndex) {
        for (int index = 0; index < data.length; index++) {
            girisList.get(parentIndex).add(data[index]);
        }
    }

    private void setCikisList(double[] data, int parentIndex) {
        /*for (int index = 0; index < data.length; index++) {
            cikisList.get(parentIndex).add(data[index]);
        }*/
    }

    public void OgrenmeBaslat() {
        int bagimli = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi();
        int bagimsiz = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
        ReaderCSV readerNesne = new ReaderCSV();
        readerNesne.clearBuffer();
        String line = null;

        while ((line = readerNesne.getSatir()) != null) {

            double[] data = ConvertDouble.convert(line.split(";"));
            double[] bagimsizDegisken = DiziKopyala.islem(data, 0, bagimsiz);
            double[] bagimliDegisken = DiziKopyala.islem(data, bagimsiz, bagimli);

        }
    }

    private void katmanDolas(double[] girisData) {
        
        Katman katmanNesne = YapayZekaNode.getnesne().getIlkKatman();
        this.setGirisList(Normalizasyon.getNesne().islemYap(girisData, new Normalize(), 0, girisData.length), 0);

        for (int index = 1; (katmanNesne != null); index++, katmanNesne = katmanNesne.sonrakiKatman) {
            
            girisData = katmanNesne.hucreKararlari(girisData);
            this.setGirisList(girisData, 0);
        }
    }
}
