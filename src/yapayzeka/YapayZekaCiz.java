/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author mehmet
 */
public class YapayZekaCiz extends JPanel {

    private final int SEKİL_BOYUT = 50;
    private int left;
    private int panelOrtasi;
    private int[] katmanNodSayisi;

    public YapayZekaCiz(int panelOrtasi) {
        this.setPanelOrtası(panelOrtasi);
        this.katmanNodSayisiHazirla();
    }

    private void setLeft() {
        this.left += 120;
    }

    private int getLeft() {
        return this.left;
    }

    private void setPanelOrtası(int panelOrtasi) {
        this.panelOrtasi = panelOrtasi;
    }

    private int getPanelOrtası() {
        return this.panelOrtasi;
    }

    private void katmanNodSayisiHazirla() {

        int uzunluk = YapayZekaVeriGiris.getNesne().getKatmanSayisi() + 1;
        this.katmanNodSayisi = new int[uzunluk];
        this.katmanNodSayisi[0] = YapayZekaVeriGiris.getNesne().getBagimsizDegiskenSayisi();
      //  this.katmanNodSayisi[uzunluk -1]  = YapayZekaVeriGiris.getNesne().getBagimliDegiskenSayisi();

        for (int index = 0; index < uzunluk-1; index++) {
            this.katmanNodSayisi[index+1] = YapayZekaVeriGiris.getNesne().getKatmanHucreSayisi(index);
        }
        


    }

    private int getKatmanNodSayisiValue(int index) {
        return this.katmanNodSayisi[index];
    }

    private int getKatmanNodSayisiSize() {
        return this.katmanNodSayisi.length;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(21, 21, 29));
        this.girisCiz(g);
        this.katmanCiz(g);

    }

    private void girisCiz(Graphics g) {

        int panelOrtasiUzaklik = 0;

        for (int i = 0; i < this.getKatmanNodSayisiValue(0); i++) {
            if (i % 2 == 0) {
                g.fillRect(this.getLeft(), this.getPanelOrtası() + panelOrtasiUzaklik, this.SEKİL_BOYUT, this.SEKİL_BOYUT);
            } else {
                panelOrtasiUzaklik += 70;
                g.fillRect(this.getLeft(), this.getPanelOrtası() - panelOrtasiUzaklik, this.SEKİL_BOYUT, this.SEKİL_BOYUT);
            }
        }
        this.setLeft();
    }

    private void katmanCiz(Graphics g) {

        int panelOrtasiUzaklik;
        for (int index = 1; index < this.getKatmanNodSayisiSize(); index++) {

            panelOrtasiUzaklik = 0;

            for (int j = 0; j < this.getKatmanNodSayisiValue(index); j++) {

                if (j % 2 == 0) {
                    g.fillOval(this.getLeft(), this.getPanelOrtası() + panelOrtasiUzaklik, this.SEKİL_BOYUT, 50);
                    this.cizgiCiz(this.getLeft() + 7, (this.getPanelOrtası() + panelOrtasiUzaklik) + 25, index, g);

                } else {
                    panelOrtasiUzaklik += 70;
                    g.fillOval(this.getLeft(), this.getPanelOrtası() - panelOrtasiUzaklik, this.SEKİL_BOYUT, this.SEKİL_BOYUT);
                    this.cizgiCiz(this.getLeft() + 7, (this.getPanelOrtası() - panelOrtasiUzaklik) + 25, index, g);
                }
            }
            this.setLeft();
        }
    }

    public void cizgiCiz(int x, int y, int index, Graphics g) {

        g.setColor(new Color(219, 27, 2));
        int panelOrtasiUzaklik = 0;
        int geciciLeft = this.getLeft() - 120;

        for (int i = 0; i < this.getKatmanNodSayisiValue(index - 1); i++) {

            if (i % 2 == 0) {
                g.drawLine(geciciLeft + 45, this.getPanelOrtası() + panelOrtasiUzaklik + 25, x, y);

            } else {
                panelOrtasiUzaklik += 70;
                g.drawLine(geciciLeft + 45, this.getPanelOrtası() - panelOrtasiUzaklik + 25, x, y);
            }
        }

        g.setColor(new Color(21, 21, 29));
    }

}
