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
public class Read {
    
    // erillinen lukija filelle ja system.inille 
    // --> syöttää metodeille, joka lukee siltä muotoon int ja double!
    
    public static ArrayList<String> frmKbd() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter values or nothing to exit");
        ArrayList<String> strings = new ArrayList<>();
        while (true) {
            String input = reader.nextLine();
            if (input.equals("")) {
                break;
            }
            strings.add((input));
        }
        return strings;
    }
    
    public static ArrayList<Integer> readInt() {
        ArrayList<String> strings = frmKbd();
        ArrayList<Integer> ints = new ArrayList<>();
        for (String string : strings) {
            ints.add(Integer.valueOf(string));
        }
        return ints;
    }
    
    public static ArrayList<Double> Dbl() {
        ArrayList<String> strings = frmKbd();
        ArrayList<Double> dbls = new ArrayList<>();
        for (String string : strings) {
            dbls.add(Double.valueOf(string));
        }
        return dbls;
    }       
}
    

