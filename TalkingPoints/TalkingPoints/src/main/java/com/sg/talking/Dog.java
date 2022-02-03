/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.27
 *purpose:
 */
public class Dog {

    private String name;
    private double weight;
    public static final String constantGenus = "canine";
    public static String genus;
    // static methods (class methods) have access to static fields
    // but not to instance fields
    public static boolean checkPetWorthy(){
        // weight = 10.0; // this will be a compiler error
        return genus == constantGenus;
       }

    // The no argument constructor is provided by default UNTIL any other
    // constructor is defined.  Then you will need to add your own no
    // argument constructor if appropriate
    public Dog(){
        genus = Dog.constantGenus;
    }
    
    // As the first line in a class constructor we have the options of 
    // calling another constructor to combine the behaviors without
    // repeating the code
    public Dog(String name, double weight){
        this(); // sets the static genus of the class?
        this.name = name;
        this.weight = weight;
    }
    
    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double wgt) {
        weight = wgt;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    // Instance methods have access to instance fields  They only need to
    // use the dot (.) operator with this if there is a local variable 
    // or parameter of the same name
    public void speak(){
        if (weight < 10.0)
        {
            System.out.println("yip");
        } else {
            System.out.println("arf");        
        }
    }

    // Instance methods have access to static fields and methods.
    void sit() {
        if (Dog.checkPetWorthy()){
            System.out.print(Dog.genus + " is ");
        }
        System.out.println("Sitting...");
    }
    
}
