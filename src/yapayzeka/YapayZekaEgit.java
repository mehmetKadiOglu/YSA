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

    private final double OGRENME_KATSAYİSİ = 0.16;
    private final double HATA_ESIGI = 0.10;
    private double hataToplami = 0.0;
    private List<List<Double>> cikisList = null;
    private List<Double> S0List = null;

    public YapayZekaEgit() {
        this.cikisList = new ArrayList<List<Double>>();
        this.S0List = new ArrayList<Double>();
        this.cikisListOlustur();
    }

    private void cikisListOlustur() {
        int parentIndex = 0;
        Katman katmanNesne = YapayZekaNode.getnesne().getIlkKatman();
        for (; (katmanNesne != null); parentIndex++, katmanNesne = katmanNesne.sonrakiKatman) {
            cikisList.add(new ArrayList<Double>());
            for (int i = 0; i < katmanNesne.getHucreAgirlikSize(); i++) {
                cikisList.get(parentIndex).add(0.0);
            }
        }
        cikisList.add(new ArrayList<Double>());
        for (int i = 0; i < YapayZekaNode.getnesne().getSonKatman().getHucreListSize(); i++) {
            cikisList.get(parentIndex).add(0.0);
        }

    }

    public double getHataOrani() {

        return this.hataToplami;
    }

    private void setHataOrani(double fark) {
        this.hataToplami = this.hataToplami + ((Math.pow(fark, 2)) / 2);
    }

    private void setS0(double[] beklenen) {
        double islem = 0.0;
        int parentIndex = this.cikisList.size() - 1;
        double cikanSonuc = 0.0;

        for (int index = 0; index < beklenen.length; index++) {
            cikanSonuc = this.cikisList.get(parentIndex).get(index);
            islem = (beklenen[index] - cikanSonuc) * (1 - cikanSonuc) * cikanSonuc;
            this.S0List.add(index, islem);
        }
    }

    private void setCikisList(double[] data, int parentIndex) {
        for (int index = 0; index < data.length; index++) {
            cikisList.get(parentIndex).add(index, data[index]);
        }
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

            double[] bagimliNormalize = Normalizasyon.getNesne().islemYap(bagimliDegisken, new DeNormalize(), bagimsizDegisken.length, bagimliDegisken.length + bagimsizDegisken.length);

            this.katmanDolas(bagimsizDegisken);
            this.setS0(bagimliNormalize);
            this.cikisKatmanAgirlikGuncelle();

        }
    }

    private void katmanDolas(double[] data) {

        Katman katmanNesne = YapayZekaNode.getnesne().getIlkKatman();
        double[] girisData = Normalizasyon.getNesne().islemYap(data, new Normalize(), 0, data.length);
        this.setCikisList(girisData, 0);

        for (int index = 1; (katmanNesne != null); index++, katmanNesne = katmanNesne.sonrakiKatman) {

           double [] girisDatasds = katmanNesne.hucreKararlari(girisData);
            this.setCikisList(girisDatasds, index);
        }
    }

    private void cikisKatmanAgirlikGuncelle() {

        int cikisListParentIndex = this.cikisList.size() - 2;
        // cikis listin en sonunda tahmin edilen bağımlı değişkenler var. Bundan dolayı -2 dedik.
        double[] hucreAgirlik;

        List<Hücre> hucreListe = YapayZekaNode.getnesne().getSonKatman().getHucreList();

        for (int parentIndex = 0; parentIndex < hucreListe.size(); parentIndex++) {
            hucreAgirlik = hucreListe.get(parentIndex).getAgirlik();
            for (int index = 0; index < hucreListe.get(0).getAgirlikSize(); index++) {
                
                hucreAgirlik[index] = hucreAgirlik[index] + (this.OGRENME_KATSAYİSİ * this.S0List.get(parentIndex) * this.cikisList.get(cikisListParentIndex).get(index));
                
            }
            hucreListe.get(parentIndex).setAgirlik(hucreAgirlik);
        }

    }
    
    private void gizliKatmanAgirliklariGuncelle(){
        
        Katman katmanNesne = YapayZekaNode.getnesne().getSonKatman();
        List<Hücre> bulundumuzKatmanHucreList = null;
        List<Hücre> sonrakiKatmanHucreList = null;
        double[] bulundumuzHucreAgirlikList = null;
        double[] sonrakiHucreAgirlikList = null;
        int cikisIndex = 3;
        
        while((katmanNesne = katmanNesne.oncekiKatman) != null){
            
            bulundumuzKatmanHucreList = katmanNesne.getHucreList();
            sonrakiKatmanHucreList = katmanNesne.sonrakiKatman.getHucreList();
            
            for (int SoListIndex = 0; SoListIndex < this.S0List.size(); SoListIndex++) {
                for (int hucreListIndex = 0; hucreListIndex < bulundumuzKatmanHucreList.size(); hucreListIndex++) {
                    for (int hucreAgirlikIndex = 0; hucreAgirlikIndex < bulundumuzKatmanHucreList.get(hucreListIndex).getAgirlikSize(); hucreAgirlikIndex++) {
                        
                    }
                }
            }
        }
    }
    
    private void setSyList(Katman katmanNesne, double S0, int cikisIndex){
        
    }
    
    
}
