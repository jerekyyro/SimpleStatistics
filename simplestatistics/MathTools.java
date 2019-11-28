/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestatistics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author s4nk4
 */
public class MathTools {
    
    public static HashMap<String, Integer> freqDistStr(ArrayList<String> categories) {
        HashMap<String, Integer> freqs = new HashMap<>();
        for (String category : categories) {
            int counter = 0;
            if (freqs.containsKey(category)) {
                counter = freqs.get(category);
                counter ++;
                freqs.put(category, counter);
            } else {
                freqs.put(category, 1);
            }
        }
        return freqs;
    }
    
    public static HashMap<Double, Integer> freqDistDbl(ArrayList<Double> nmbrs) {
        HashMap<Double, Integer> freqs = new HashMap<>();
        for (Double number : nmbrs) {
            int counter = 0;
            if (freqs.containsKey(number)) {
                counter = freqs.get(number);
                counter ++;
                freqs.put(number, counter);
            } else {
                freqs.put(number, 1);
            }
        }
        return freqs;
    }
    
    public static HashMap<String, String> fDInttoStrings (HashMap<String, Integer> freqdists) {
        // for modes method: it reads String-hashmaps, which is the most compatible;
        // make similar method fro converting int's to Strings
        HashMap<String, String> dblstoStrings = new HashMap<>();
        for (String value : freqdists.keySet()) {
            String svalue = value;
            String sn = Integer.toString(freqdists.get(value));
            dblstoStrings.put(svalue, sn);
        }
        return dblstoStrings;
    }


    public static HashMap<String, String> fDDbltoStrings (HashMap<Double, Integer> freqdists) {
        // for modes method: it reads String-hashmaps, which is the most compatible;
        // make similar method fro converting int's to Strings
        HashMap<String, String> dblstoStrings = new HashMap<>();
        for (Double value : freqdists.keySet()) {
            String svalue = Double.toString(value);
            String sn = Integer.toString(freqdists.get(value));
            dblstoStrings.put(svalue, sn);
        }
        return dblstoStrings;
    }
    
    public static String modeFromFD(HashMap<String, String> freqdists) {
        // use this for all types, just convert them to Strings first
        String bigstr = "";
        int biggest = 0;
        int tops = 0;
        for (String value : freqdists.keySet()) {
            int n = Integer.valueOf(freqdists.get(value));
            if (n > biggest) {
                bigstr = value;
                tops = 1;
                biggest = n;
            } else if (n == biggest) {
                tops ++;
                bigstr = bigstr+", "+value;
            }
        }
        if (tops == 1) {
            return "unimodal: "+bigstr;
        } else if (tops == 2) {
            return "bimodal: "+bigstr;
        } else {
            return "multimodal: "+bigstr;
        }
    }
    
    public static double meanFromFreqDistr(HashMap<Double, Integer> values) {
        double sum = 0;
        int n = 0;
        for (Double value : values.keySet()) {
            sum = sum + value * values.get(value);
            n = n + values.get(value);
        }
        return sum / (double) n;
    }
    
    // ei toimi
    public static double geoMeanFromFreqDistr(HashMap<Double, Integer> values) {
        double log = 0;
        double n = 0;
        for (double value : values.keySet()) {
            log = log + Math.pow(value, values.get(value));
            n = n + values.get(value);
        }
        return Math.pow(log, 1/n);
    }
    
    public static double mean(ArrayList<Double> values) {
        double sum = 0;
        double n = 0;
        for (Double value : values) {
            sum = sum + value;
            n ++;
        }
        return sum / n;
    }
    
    // toimii!!
    public static double geoMean(ArrayList<Double> values) {
        double sum = 0;
        double n = 0;
        // System.out.println("calculating geoMean...");
        for (Double value : values) {
            if (sum == 0) {
                sum =  value;
                n ++;
                //System.out.println("sum & n: "+sum+", "+n);
            } else {
                sum = sum * value;
                n ++;
                //System.out.println("sum & n: "+sum+", "+n);
            }
        }
        n = 1/n;
        return Math.pow(sum, (n));
    }

}
