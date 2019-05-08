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
public class Katman {

    private List<Hücre> hucreList;
    public Katman sonrakiKatman = null;
    public Katman oncekiKatman = null;

    public Katman(int uzunluk, int hucreBaglantiSayi) {

        this.hucreList = new ArrayList<Hücre>();
        this.setHucreList(uzunluk, hucreBaglantiSayi);
    }

    private void setHucreList(int uzunluk, int hucreBaglantiSayi) {

        for (int i = 0; i < uzunluk; i++) {

            Hücre hücre = new Hücre(hucreBaglantiSayi);
            this.hucreList.add(hücre);
        }
    }

    public int getHucreListSize() {

        return this.hucreList.size();
    }
    public int getHucreAgirlikSize(){
        return this.hucreList.get(0).getAgirlikSize();
    }

    private Hücre getListElement(int index) {

        return this.hucreList.get(index);
    }

    public double[] hucreKararlari(double[] data) {

        /*
        
        sdsa asdsa d sads
        */
        double[] kararData = new double[this.getHucreListSize()];

        for (int i = 0; i < this.getHucreListSize(); i++) {
            kararData[i] = this.getListElement(i).kararAl(data);
        }

        return kararData;
    }

    public double[] iletisimBaslat(double[] data) {

        if (this.sonrakiKatman != null) {
            return sonrakiKatman.iletisimBaslat(this.hucreKararlari(data));
        } else {
            return this.hucreKararlari(data);
        }

    }
}
