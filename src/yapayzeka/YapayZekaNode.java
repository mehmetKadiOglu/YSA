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

    private Katman ilkKatman = null;
    private Katman sonKatman = null;

    static private YapayZekaNode node = null;

    private YapayZekaNode() {

    }

    static YapayZekaNode getnesne() {
        if (node == null) {
            node = new YapayZekaNode();
        }

        return node;

    }

    public Katman getIlkKatman() {
        return this.ilkKatman;
    }

    public Katman getSonKatman() {
        return this.sonKatman;
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

    public double[] kararVer(double[] bagimsizDegisken) {

        int bagimli = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi();

        double[] normalizeData = Normalizasyon.getNesne().islemYap(bagimsizDegisken, new Normalize(), 0, bagimsizDegisken.length);

        double[] kararData = this.ilkKatman.iletisimBaslat(normalizeData);

        double[] deNormalizeData = Normalizasyon.getNesne().islemYap(kararData, new DeNormalize(), bagimsizDegisken.length, bagimli + bagimsizDegisken.length);

        return deNormalizeData;
    }
}
