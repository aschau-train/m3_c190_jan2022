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
public class EconomySoup extends Soup {
    private double UNIT_PRICE = 0.99;
    private double DISCOUNT_PRICE = 3.00;
    private int QUANTITY_FOR_DISCOUNT = 4;

    public EconomySoup(int quantity) {
        super(quantity);   
    }
    
    public EconomySoup(int quantity, double unitPrice, double discountPrice, int quantityForDiscount){
        this(quantity);
        UNIT_PRICE = unitPrice;
        DISCOUNT_PRICE = discountPrice;
        QUANTITY_FOR_DISCOUNT = quantityForDiscount;
        
    }
    
    @Override 
    public double getPrice(){
        int qty = getQuantity();
        double fullPrice = qty % QUANTITY_FOR_DISCOUNT * UNIT_PRICE;
        fullPrice += qty / QUANTITY_FOR_DISCOUNT * DISCOUNT_PRICE;
        return fullPrice;
    }

    @Override
    public String demoVirtual(){return "Economy Soup";}

    @Override
    public String displayDetails() {
        return String.format(
        "%d cans of EconomySoup %.2f (quantity discounts apply) = %.2f",
                super.getQuantity(),
                UNIT_PRICE,
                getPrice());
    }

}
