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
public class Hücre {

    private double agirlik[];

    public Hücre(int agirlikUzunlugu) {

        this.setAgirlik(agirlikUzunlugu);
    }

    public double[] getAgirlik() {
        return agirlik;
    }

    private void setAgirlik(int agirlikUzunlugu) {

        this.agirlik = new double[agirlikUzunlugu];
        for (int index = 0; index < agirlikUzunlugu; index++) {
            this.agirlik[index] = Math.random();
        }

    }
    public void setAgirlik(double yeniAgirlik[]){
        this.agirlik = yeniAgirlik;
    }
    public int getAgirlikSize(){
        return agirlik.length;
    }

    public double kararAl(double[] data) {

        double toplamDeger = this.toplamFonk(data);
        double fNet = (1)/(1 + ( this.kareAl(toplamDeger * -1) ));

        return fNet;

    }

    private double kareAl(double ust) {
        return Math.pow(Math.E, ust);
    }

    private double toplamFonk(double[] data) {

        double toplam = 0.0;
        for (int index = 0; index < this.getAgirlik().length; index++) {
            toplam += data[index] * this.getAgirlik()[index];
        }
        return toplam;
    }

}
