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
 *
 * YapayZekaVeriGiris sınıfında kullanıcıdan girilmesi beklenen parametreler
 * tutuluyor. Bunlar: Bağımlı değişken sayısı Bağımsız değişken sayısı Katman
 * Sayısı Katmanda bulunan hucrelerin sayısı Hucrelerin bağlantı sayısı Okunacak
 * olan csv dosya yolu
 *
 * YapayZekaNode sınıfı, içerisinde yapay sinir ağının başlangıç
 * katman(katmanlar birbirlerine bağlıdır!) nesnesi bulunuyor. Bu nesne ile
 * hesaplama işlemi başlatılıyor.
 *
 * YapayZekaIslem sınıfı, YapayZekaNode sınıfını kullanır. Node sıfını üzerinden
 * tahmin işlemi yapılmadan önce gerekli olan işlemleride içerisinde barındırır.
 * Bunlar: Mormalisazyon için bağımsız-bağımlı değişkenlerin değer aralıklarını
 * setleme işlelerini başlatır.
 *
 * YapayZekaCiz sınıfır, kullacının oluşturduğu ağı JPanel üzerinde gösterilmesi
 * için kullanılıyor
 *
 * DegerARaliklari sınıfır, YapayZekaNode sınıfında kullanılıyor. Bağımlı -
 * Bağımsız değişkenlerin sınır aralıklarını bulmak için kullanılıyor.
 *
 *
 *
 *
 *
 * @author mehmet
 */
public class YapayZeka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //          this.setDosyaYolu("D://lazimliklar/dersler/Machine_Learning/Uygulama/deneme2.csv");
       /* Command command = new Command();

        command.verileriAl();
        command.normalizeYap();

        command.yapayZekaTahmin();
        command.yapayZekaCiz();*/
       
       List<String> stt = new ArrayList<>();
       stt.add("hirrrim");
       stt.add("hirrrim2");
       stt.add("hirrrim3");
       System.out.println(stt.size());
       stt.clear();
       System.out.println(stt.size());
       
    }
}
