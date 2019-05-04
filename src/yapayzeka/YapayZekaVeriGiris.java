/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.util.Scanner;

/**
 *
 * @author mehmet
 */
public class YapayZekaVeriGiris {

    private static YapayZekaVeriGiris nesne = null;
    
    private int katmanSayisi;
    private int bagimsizDegiskenSayisi;
    private int bagimliDegiskenSayisi;
    private int[] katmanHucreSayisi;
    private int[] hucreBaglantiSayisi;
    private String dosyaYolu;
    private Scanner input;

    private YapayZekaVeriGiris(){
        this.setInput();
    }
    
    private Scanner getInput() {
        return input;
    }
    private void setInput() {
        this.input = new Scanner(System.in);;
    }

    public int getKatmanSayisi() {
        return katmanSayisi;
    }
    private void setKatmanSayisi(int katmanSayisi) {
        this.katmanSayisi = katmanSayisi;
    }
    

    public int getBagimsizDegiskenSayisi() {
        return bagimsizDegiskenSayisi;
    }
    private void setBagimsizDegiskenSayisi(int bagimsizDegiskenSayisi) {
        this.bagimsizDegiskenSayisi = bagimsizDegiskenSayisi;
    }
    

    public int getBagimliDegiskenSayisi() {
        return bagimliDegiskenSayisi;
    }
    private void setBagimliDegiskenSayisi(int bagimliDegiskenSayisi) {
        this.bagimliDegiskenSayisi = bagimliDegiskenSayisi;
    }
    

    public int getKatmanHucreSayisi(int index){
       return this.katmanHucreSayisi[index];
    }
    private void setKatmanHucreSayisi(int index, int value) {
        this.katmanHucreSayisi[index] = value;
    }
    private void setKatmanHucreSayisi() {
        this.katmanHucreSayisi = new int[this.getKatmanSayisi()];
    }
    

    public int getHucreBaglantiSayisi(int index) {
        return hucreBaglantiSayisi[index];
    }
    private void setHucreBaglantiSayisi(int index, int value) {
        this.hucreBaglantiSayisi[index] = value;
    }
    private void setHucreBaglantiSayisi() {
        this.hucreBaglantiSayisi = new int[this.getKatmanSayisi()];
    }
    

    public String getDosyaYolu() {
        return dosyaYolu;
    }
    private void setDosyaYolu(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }
    

    public void katmanSayisiAl() {
        System.out.print("Lütfen katman sayi gir ");
        this.setKatmanSayisi(this.getInput().nextInt() + 1); // bitişide katman olarak alıyorum
    }
    public void katmanHucreSayilariAl() {

        this.setKatmanHucreSayisi();

        for (int index = 0; index < this.getKatmanSayisi() - 1; index++) {
            System.out.print((index + 1) + ". katmandaki düğüm sayisi ");
            this.setKatmanHucreSayisi(index, input.nextInt());
        }

    }
    public void bagimsizDegiskenSayisiAl() {

        System.out.print("Bagimsiz Degisken Sayisi Giriniz ");
        this.setBagimsizDegiskenSayisi(this.getInput().nextInt());
    }
    public void bagimliDegiskenSayisiAl() {

        System.out.print("Bagimli Degisken Sayisi Giriniz ");
        this.setBagimliDegiskenSayisi(this.getInput().nextInt());
    }
    public void hucreBaglantiSayisiHazirla() {

        this.setHucreBaglantiSayisi();

        this.setHucreBaglantiSayisi(0, this.getBagimsizDegiskenSayisi());
        this.setKatmanHucreSayisi(this.getKatmanSayisi()-1, this.getBagimliDegiskenSayisi());

        for (int index = 1; index < this.getKatmanSayisi(); index++) {

            this.setHucreBaglantiSayisi(index, this.getKatmanHucreSayisi(index -1 ));
        }
    }
    public void dosyaYoluAl(){
        System.out.print(" Dosya yolunu giriniz ");
        this.setDosyaYolu(this.getInput().next());
        System.out.println();
    }
    
    static public YapayZekaVeriGiris getNesne(){
        
        if(YapayZekaVeriGiris.nesne == null)
            YapayZekaVeriGiris.nesne = new YapayZekaVeriGiris();
        
        return YapayZekaVeriGiris.nesne;
    }

}
