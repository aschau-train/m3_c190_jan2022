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
public class GourmetSoup extends Soup {

    private double UNIT_PRICE = 3.95;

    public GourmetSoup(int quantity, double unit_price) {
        super(quantity);
    }
    
    @Override
    public double getPrice(){
        return super.getQuantity() * UNIT_PRICE;
    }
    
    @Override
    public String demoVirtual() {return  "Gourmet Soup";}

    @Override
    public String displayDetails() {
    return String.format(
        "%d cans of GourmetSoup @.2f  = $%.2f",
                super.getQuantity(),
                UNIT_PRICE,
                getPrice());        
    }
}
