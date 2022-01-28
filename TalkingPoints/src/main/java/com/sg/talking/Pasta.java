/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.28
 *purpose:
 */
public class Pasta implements GroceryItem {

    private int quantity;
    private static double UNIT_PRICE = 0.99f;
    public static void setUNIT_PRICE(double unit_price) { UNIT_PRICE = unit_price;}

    public Pasta(int i) {
    }

    @Override
    public String displayDetails() {
        return String.format("Soup %d cans @ %.2f/per can = %.2f", quantity, 
                                Pasta.UNIT_PRICE, this.getPrice());
    }

    @Override
    public double getPrice() {
        return quantity * UNIT_PRICE;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
