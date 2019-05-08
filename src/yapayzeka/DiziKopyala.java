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
public class DiziKopyala {

    public static double[] islem(double[] kopyalanakDizi, int kopyaBaslangicIndex, int yeniDiziUzunluk) {

        double[] data = new double[yeniDiziUzunluk];
        System.arraycopy(kopyalanakDizi, kopyaBaslangicIndex, data, 0, yeniDiziUzunluk);
        return data;

    }
}
