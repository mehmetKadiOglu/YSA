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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // D://lazimliklar/dersler/Machine_Learning/Uygulama/deneme2.csv
        // Command command = new Command();

        //  command.verileriHazirla();
        // command.yapayZekaTahmin();
        // command.yapayZekaCiz();
        // double sonuc = (1 - Math.pow(Math.E, (-2*0.5)) ) / (1 + Math.pow(Math.E, (2*0.5)) );
        BufferedReader buffer = null;
        FileReader aa = new FileReader("D://lazimliklar/dersler/Machine_Learning/Uygulama/deneme2.csv");
        buffer = new BufferedReader(aa);
        buffer.

        String line = null;

        try {
            System.out.println(buffer.readLine());
            System.out.println(buffer.readLine());
            System.out.println(buffer.readLine());
            buffer.mark(0);
            System.out.println(buffer.readLine());
            System.out.println(buffer.readLine());
            buffer.reset();
            buffer.reset();
            buffer.reset();

            buffer.mark(0);
            buffer.mark(0);
            buffer.reset();
            System.out.println("-------------");
            System.out.println(buffer.readLine());
            System.out.println(buffer.readLine());
            System.out.println(buffer.readLine());
            System.out.println("-------------");
            System.out.println("-------------");
        } catch (IOException ex) {
            Logger.getLogger(MinDeger.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scanner scanner = new Scanner(new File("D://lazimliklar/dersler/Machine_Learning/Uygulama/deneme2.csv"));
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
            //List<String> line = parseLine(scanner.nextLine());
            // System.out.println("Country [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
        }
         System.out.println("-------------");
          System.out.println("-------------55");
        scanner.reset();
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
            //List<String> line = parseLine(scanner.nextLine());
            // System.out.println("Country [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
        }
    }
}
