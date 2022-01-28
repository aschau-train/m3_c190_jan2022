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
public class DemoObjects {

    static Scanner cin = new Scanner(System.in);
    
    public static void demoObjects(String[] args) {
        System.out.println("This demo deals with classes and objects");
        System.out.println("");
        System.out.println("");
        
        Dog pet = new Dog("Lady",6.0);
        pet.setName("Lady");
        Dog stray = new Dog();
        System.out.println(Dog.genus);
        stray.setName("Tramp");
        stray.setWeight(12.0);
        pet.speak();
        pet.sit();
        stray.speak();
        
        System.out.println(Dog.genus);
        System.out.println(pet.genus);
        System.out.println(Dog.checkPetWorthy());
        
        
// arguments are passed by value (copy)        
        int x = 2, y = 3;
        swap(x,y);
        System.out.println("x = " + x + " y = " + y);
        
// This will deal with final as a parameter setting        
        Dog lassie = new Dog();
        lassie.setName("Lassie");
        passByValueDemo(lassie);
        System.out.println(lassie.getName());
    }

    private static void passByValueDemo(final Dog anyDog) {
       // anyDog = new Dog();
        anyDog.setName("Benjie");
    }

    private static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
      
    }

    

}
