/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzeka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehmet
 */
public class YapayZeka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // D://lazimliklar/dersler/Machine_Learning/Uygulama/deneme2.csv
      //          this.setDosyaYolu("D://lazimliklar/dersler/Machine_Learning/Uygulama/deneme2.csv");
         Command command = new Command();

          command.verileriHazirla();
        // command.yapayZekaTahmin();
         command.yapayZekaCiz();
        // double sonuc = (1 - Math.pow(Math.E, (-2*0.5)) ) / (1 + Math.pow(Math.E, (2*0.5)) );
    }
}
