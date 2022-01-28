/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

import java.util.Scanner;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.27
 *purpose:
 */
public class DemoArrays {
    private static Scanner cin;// = new Scanner(System.in);

    public static void demoArrays(String[] args) {
        System.out.println("This demo deals with methods and arrays");
        System.out.println("");
        System.out.println("");
        
        // First show how methods are called
        // and can have the same name, but different
        // arguments
        
//        cin = new Scanner(System.in);
//        String prompt = getUserInput();
//        int first = getUserInput("Input the first number");
//        displayResponse(prompt, first);
//
//        int second = getUserInput("Input the second number");
//        displayResponse(prompt, second);
        
        // Now show  how arrays can be one dimensional, multi-dimensional
        // and jagged and are zero based index
        // also show foreach syntax
        //        for (type value : fromcontainer)
        //        {
        //        }
        createAnArrayLocally(1,2,3,4,5);
    }

    
    
    private static int getUserInput(String message) {
        System.out.println(message);
        return cin.nextInt();
        
    }

    private static String getUserInput() {
        System.out.println("Enter a phrase");
        return cin.nextLine();
        
    }

    private static void displayResponse(String prompt, int answer) {
        System.out.println(prompt);
        System.out.println(answer);
    }

    private static void createAnArrayLocally(int i, int i0, int i1, int i2, int i3) {
        
        //int[] arrayOfInts;
        int[] arrayOfInts = new int[5];
        arrayOfInts[0] = i;
        arrayOfInts[1] = i0;
        arrayOfInts[2] = i1;
        arrayOfInts[3] = i2;
        arrayOfInts[4] = i3;
        
        
        int[] other = {i, i0, i1, i2, i3};
                
        // int[] other = new int[] {i, i0, i1, i2, i3};

        int[][] myTable = {{1,2,3},{4,5,6}};
        int answer = myTable[0][1];
        int[] holding = myTable[1];
        
        
        
        int[][] jagged = new int[2][];
        jagged[0] = new int[2];
        jagged[1] = new int[] {1,2,3,4,5,6};
        System.out.println(jagged.length);
        int[] hold = jagged[1];
        for (int j = 0; j < hold.length;j++){
            System.out.println(hold[j]);
        }
        
        for (int x : other){
            System.out.println(x);
        }

        for(int[] h : jagged){
            for(int x : h){
                
            }
        }
        
    }
    
    
}
