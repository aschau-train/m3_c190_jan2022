/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.windowmaster;

import java.util.Scanner;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.26
 *purpose:
 */
public class WindowMaster {
    public static void main(String[] args) {
        
        // declare variables for height and width
        float height;
        float width;
        
        // declare variables for area perimeter and cost
        float areaOfWindow;
        float perimeterOfWindow;
        float cost;
        
        float glassCost = 3.5f;
        float trimCost = 2.25f;
        
        // Getting input
        // declare a variable for a scanner to System.in
        Scanner myScanner = new Scanner(System.in);
        
        // prompt user for height
        System.out.println("Please enter window height (ft): ");
        height = myScanner.nextFloat();
        
        // prompt user for width
        System.out.println("Please enter window width (ft): ");
        width = myScanner.nextFloat();
        
        // calculate area and perimiter
        areaOfWindow = height * width;
        perimeterOfWindow = (2 * height) + (2 * width);
        
        // accumulate costs
        cost = areaOfWindow * glassCost;
        cost += perimeterOfWindow * trimCost;
        
        // display the result
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimiter = " + perimeterOfWindow);
        System.out.println("Total Cost = CAD " + cost);
        
        
    }
}
