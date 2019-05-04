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
       // Random r = new Random();
        for (int index = 0; index < agirlikUzunlugu; index++) {
            this.agirlik[index] = Math.random();
           // this.agirlik[index] =  -1 +  (2 * r.nextDouble())  ;
           System.out.println(this.getAgirlik()[index]);
        }

    }

    public double kararAl(double[] data) {

        double toplamDeger = this.toplamFonk(data);
       // double fNet = (1 - this.kareAl(-2.0 * toplamDeger) ) / (1 + this.kareAl(2.0 * toplamDeger ) );
        double fNet = (1)/(1 + ( this.kareAl(toplamDeger * -1) ));
        System.out.println("Sigmoid sonuc  = " + fNet + "    Toplam Fonksiyonundan gelen sonuc = " + toplamDeger);

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
