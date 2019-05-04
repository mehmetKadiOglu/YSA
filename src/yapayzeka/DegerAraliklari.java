/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehmet
 */
class ConvertDouble {

    static public double[] convert(String[] data) {

        double[] convertData = new double[data.length];

        for (int index = 0; index < data.length; index++) {
            convertData[index] = Double.valueOf(data[index]);
        }

        return convertData;
    }
}

abstract class DegerAralikIslem {

    protected BufferedReader buffer;
    protected double[] aralikArray;

    public DegerAralikIslem(String dosyaAdi) {

        try {
            this.buffer = new BufferedReader(new FileReader(dosyaAdi));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DegerAralikIslem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    abstract void aralikBul();

    protected void setAralikArray(int index, double value) {

        this.aralikArray[index] = value;
    }

    protected double getAralikArrayValue(int index) {
        return this.aralikArray[index];

    }

    public double[] getDegerArray() {
        return this.aralikArray;
    }

}

class MinDeger extends DegerAralikIslem {

    public MinDeger(int parametreSayisi) {

        super(YapayZekaVeriGiris.getNesne().getDosyaYolu());
        this.setAralikArray(parametreSayisi);
    }

    private void setAralikArray(int parametreSayisi) {

        this.aralikArray = new double[parametreSayisi];

        for (int index = 0; index < parametreSayisi; index++) {
            this.aralikArray[index] = Double.MAX_VALUE;
        }

    }

    @Override
    public void aralikBul() {

        String line = "";
        try {
            this.buffer.readLine();
            while ((line = this.buffer.readLine()) != null) {
                this.karsilastirmaIslem(ConvertDouble.convert(line.split(";")));
            }

        } catch (IOException ex) {
            Logger.getLogger(MinDeger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void karsilastirmaIslem(double[] data) {

        for (int index = 0; index < data.length; index++) {
            if (this.getAralikArrayValue(index) > data[index]) {
                this.setAralikArray(index, data[index]);
            }
        }

    }

}

class MaxDeger extends DegerAralikIslem {

    public MaxDeger(int parametreSayisi) {
        super(YapayZekaVeriGiris.getNesne().getDosyaYolu());
        this.setAralikArray(parametreSayisi);
    }

    private void setAralikArray(int parametreSayisi) {
        this.aralikArray = new double[parametreSayisi];
    }

    @Override
    public void aralikBul() {

        String line = "";
        try {
            this.buffer.readLine();
            while ((line = this.buffer.readLine()) != null) {
                this.karsilastirmaIslem(ConvertDouble.convert(line.split(";")));
            }

        } catch (IOException ex) {
            Logger.getLogger(MinDeger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void karsilastirmaIslem(double[] data) {

        for (int index = 0; index < data.length; index++) {
            if (this.getAralikArrayValue(index) < data[index]) {
                this.setAralikArray(index, data[index]);
            }
        }

    }

}
