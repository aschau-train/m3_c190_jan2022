/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class SimpleFileIO {

    static void demoFileIO(String[] args) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("OutputFile.txt"));
        } catch (IOException ex) {
            Logger.getLogger(SimpleFileIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null){
                out.flush();
                out.close();
                out = null;
            }
        }
        
    }
    
    

}
