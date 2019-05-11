/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;


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

    protected double[] aralikArray;

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



        ReaderCSV nesne = new ReaderCSV();
        nesne.clearBuffer();
        String line = null;

        while ((line = nesne.getSatir()) != null) {
            this.karsilastirmaIslem(ConvertDouble.convert(line.split(";")));
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
        this.setAralikArray(parametreSayisi);
    }

    private void setAralikArray(int parametreSayisi) {
        this.aralikArray = new double[parametreSayisi];
    }

    @Override
    public void aralikBul() {
        
            ReaderCSV nesne = new ReaderCSV();
            nesne.clearBuffer();
            String line = null;

            while ((line = nesne.getSatir()) != null) {
                this.karsilastirmaIslem(ConvertDouble.convert(line.split(";")));
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
