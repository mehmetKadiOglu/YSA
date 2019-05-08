/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

/**
 *
 * @author mehmet
 */
public class YapayZekaNode {

    public Katman ilkKatman = null;
    public Katman sonKatman = null;

    static private YapayZekaNode node = null;

    private YapayZekaNode() {

    }

    static YapayZekaNode getnesne() {
        if (node == null) {
            node = new YapayZekaNode();
        }

        return node;

    }

    public void katmanHazirla() {
        
        this.ilkKatman = new Katman(YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(0), YapayZekaVeriGiris.getNesne().getHucreBaglantiSayisi(0));

        Katman yedekKatman = ilkKatman;
        for (int index = 1; index < YapayZekaVeriGiris.getNesne().getKatmanSayisi(); index++) {
            Katman katman = new Katman(YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(index), YapayZekaVeriGiris.getNesne().getHucreBaglantiSayisi(index));
            yedekKatman.sonrakiKatman = katman;
            katman.oncekiKatman = yedekKatman;
            
            yedekKatman = katman;
        }
        
        this.sonKatman = yedekKatman;
    }
    

    public void kararVer(double[] bagimliDegisken, double[] bagimsizDegisken) {
        

        double[] normalizeData = Normalizasyon.getNesne().islemYap(bagimsizDegisken, new Normalize(), 0, bagimsizDegisken.length);

        double[] kararData = this.ilkKatman.iletisimBaslat(normalizeData);
        
        double[] deNormalizeData = Normalizasyon.getNesne().islemYap(kararData, new DeNormalize(), bagimsizDegisken.length, bagimliDegisken.length + bagimsizDegisken.length);
        
        for (int i = 0; i < deNormalizeData.length; i++) 
            System.out.println(deNormalizeData[i] + " tahmin. Dogru " + bagimliDegisken[i]);
        
        
        System.out.println();
    }
}
