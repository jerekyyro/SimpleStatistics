/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author s4nk4
 */
public class SimpleStatistics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        System.out.println("Getting a list of observations.");
        System.out.println("Enter 1 for integers, 2 for doubles or 3 for strings");
        int selection = Integer.valueOf(reader.nextLine());
        //if (selection != 1 || selection != 2 || selection != 3) {
        //    System.out.println("Invalid input.");
        //}
        // GETTING INTEGERS
        if (selection == 1) {
            ArrayList<Integer> integers = new ArrayList<>();
            System.out.println("Enter integers, Z exits:");
            while (true) {
                String input = reader.nextLine();
                if (input.equals("Z")) {
                    break;
                }
                integers.add(Integer.valueOf(input));
            }
        }
        //DOUBLES
        
        if (selection == 2) {
            ArrayList<Double> doubles = new ArrayList<>();    
            doubles = Read.Dbl();
            //System.out.println("Enter doubles, Z exits:");
            //while (true) {
            //    String input = reader.nextLine();
            //    if (input.equals("Z")) {
            //        break;
            //    }
            //    doubles.add(Double.valueOf(input));
            //}
        
        System.out.println(MathTools.mean(doubles));
        System.out.println(MathTools.meanFromFreqDistr(MathTools.freqDistDbl(doubles)));
        System.out.println(MathTools.geoMean(doubles));
        //ei toimi System.out.println(MathTools.geoMeanFromFreqDistr(MathTools.freqDistDbl(doubles)));
        
        }
//STRINGS
        if (selection == 3) {
            ArrayList<String> strings = new ArrayList<>();    
            strings = Read.frmKbd();
            HashMap<String, Integer> srts = MathTools.freqDistStr(strings);
            HashMap<String, String> modes = MathTools.fDInttoStrings(srts);
            System.out.println(MathTools.freqDistStr(strings));
            System.out.println(MathTools.modeFromFD(modes));
        }
        if (selection != 1 || selection !=2 || selection != 3) {
            System.out.println("invalid input!");
        }
// DOING THINGS WITH THE LISTS
        
        
        
        
    }
    
}
