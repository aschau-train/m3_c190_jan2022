/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.talking;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.28
 *purpose:
 */
public interface GroceryItem {

    String displayDetails();

    double getPrice();

    /**
     * @return the quantity
     */
    int getQuantity();
    void setQuantity(int quantity);
    
}
