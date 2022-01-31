/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class StateCapitals {
    private Map<String, String> capitals;
    
    public StateCapitals(){
        capitals = new HashMap<>();
        loadStateCapitals();
    }

    private void loadStateCapitals() {
        Scanner cin = null;
        
        try {
        FileReader fr = new FileReader("./Data/StateCapitals.txt");
        BufferedReader br = new BufferedReader(fr);
        cin = new Scanner(br);
            while (cin.hasNextLine()){
                String currentLine = cin.nextLine();
                String[] inputs = currentLine.split("::");
                if (inputs.length == 2){
                    capitals.put(inputs[0], inputs[1]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StateCapitals.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (cin != null){
                cin.close();
            }
        }
        
        

    }

    public void displayCapitals() {
        capitals.forEach(
                (state,capital) -> 
                        System.out.println(
                                "The capital of " + state + " is " + capital));
    }
    
    
}
