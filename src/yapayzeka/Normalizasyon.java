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
 * @author mehmet
 */
interface NormalizeIslem {
   
    double [] islemYap(double [] data, List <Double> maxList, List <Double> minList, int baslangic, int bitis );
}
public class Normalizasyon {
    
    private List <Double> maxList;
    private List <Double> minList;
    static private  Normalizasyon normalizasyon = null;
    
    private Normalizasyon(){
        this.maxList = new ArrayList<>();
        this.minList = new ArrayList<>();
    }

    public double getMaxList(int index) {
        return this.maxList.get(index);
    }

    public void setMaxList(double [] maxList) {
        
        for(double value: maxList)
            this.maxList.add(value);
    }

    public double getMinList(int index) {
        return minList.get(index);
    }

    public void setMinList(double [] minList) {
        for(double value: minList)
            this.minList.add(value);
    }
    
    public double [] islemYap(double[] data, NormalizeIslem islem, int baslangic, int bitis){
        
        return islem.islemYap(data, this.maxList, this.minList, baslangic, bitis);
    }
    
    static public Normalizasyon getNesne(){
        
        if( normalizasyon == null)
            normalizasyon = new Normalizasyon();
        
        return normalizasyon;
    }
}

class Normalize implements NormalizeIslem{
    @Override
    public double[] islemYap(double[] data, List <Double> maxList, List <Double> minList, int baslangic, int bitis) {
        
        double[] normalizeData = new double[bitis];
       // System.out.println(maxList.size()+" "+minList.size()+" "+baslangic+" "+bitis+" "+ data.length);
        for (int index = baslangic; index < bitis; index++) 
            normalizeData[index] = (data[index] - minList.get(index)) / (maxList.get(index) - minList.get(index)) ;
        
        return normalizeData;
    }
    
}
class DeNormalize implements NormalizeIslem{
    @Override
    public double[] islemYap(double[] data, List <Double> maxList, List <Double> minList, int baslangic, int bitis) {
        
        
        double[] normalizeData = new double[bitis - baslangic ];
       // System.out.println(maxList.size()+" "+minList.size()+" "+baslangic+" "+bitis+" ");
        for (int index = baslangic, index2=0; index < bitis; index2++, index++) 
            normalizeData[index2] = data[index2] * (maxList.get(index)-minList.get(index)) + minList.get(index);
        
        return normalizeData;
    }
    
}