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
public abstract class Soup implements GroceryItem {

    private int quantity;

    public Soup(int quantity){
        this.quantity = quantity;
    }
  
    // This method defined in Soup is virtual
    // and can be overridden in a sub-class
    public String demoVirtual(){return "Soup";}

    // Abstract you are required to override
    //public abstract String demoVirtual();

    // If you add final instead of abstract and provide a body
    // any class extending Soup CANNOT overdie demoVirtual
    // public final String demoVirtual(){return "Soup";}

    

    /**
     * @return the quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {        
        this.quantity = quantity;
        
    }

}
