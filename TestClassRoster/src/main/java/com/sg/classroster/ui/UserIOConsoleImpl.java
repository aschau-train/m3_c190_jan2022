/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.ui;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.29
 *purpose:
 */
public class UserIOConsoleImpl implements UserIO  {

    private final Scanner cin;
    public UserIOConsoleImpl() {
        cin = new Scanner(System.in);
    }

    // Overloaded constructor to allow reassignment of input stream
    UserIOConsoleImpl(Scanner inputStream) {
        cin = inputStream;
    }

    @Override
    public void print(String prompt){
        System.out.println(prompt);
    }
    
    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return cin.nextDouble();
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double result = readDouble(prompt);
        if (result >= min && result <= max){
            return result;
        }
        return Double.NaN;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return cin.nextFloat();
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result = readFloat(prompt);
        if (result >= min && result <= max){
            return result;
        }
        return Float.NaN;
        
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
//        int result = cin.nextInt();
//        cin.nextLine();
        // - OR - 
         int result;//  = cin.nextInt();
         result = Integer.parseInt(cin.nextLine());
        return result;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result = readInt(prompt);
        if (result >= min && result <= max){
            return result;
        }
        return 0;
        
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return cin.nextLong();
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result = readLong(prompt);
        if (result >= min && result <= max){
            return result;
        }
        return 0L;
    }

    @Override
    public String readString(String prompt) {
        String result = "";
        System.out.println(prompt);
        if (cin.hasNextLine()) result = cin.nextLine();
        return result;
    }

    
}
