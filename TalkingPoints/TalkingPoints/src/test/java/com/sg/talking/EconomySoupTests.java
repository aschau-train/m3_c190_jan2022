/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.talking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author augie
 */
public class EconomySoupTests {

    Soup soup;
    Soup quantityDiscountSoup;

    @BeforeEach
    public void setUp() {
        soup = new EconomySoup(3);
        quantityDiscountSoup = new EconomySoup(10);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void confirmCostOfThree() {
        // This causes problems with equality comparisons
        int quantity = 3;
        double unit_price = 0.99;
        double expected = unit_price * quantity;
        double actual = soup.getPrice();
       // Round the results to 2 decimal places
       expected = Math.round(expected);
       actual = Math.round(actual);
       
       // Or format them as 2 decimal strings
//        String expected = String.format("%.2f", 2.99d * 3);
//        String actual = String.format("%.2f", soup.getPrice());
        assertEquals(expected, actual);
    }
    
    @Test
    public void confirmQuantityDiscountPerFour() {
        soup = new EconomySoup(10);
        int quantity = 10;
        double unit_price = 0.99;
        double discount_price = 3.0;
        
        // four soups for 3.0
        double expected = quantity / 4 * discount_price + quantity % 4 * unit_price;
        double actual = soup.getPrice();
       
        // Round the results to 2 decimal places
       expected = Math.round(expected);
       actual = Math.round(actual);
       // Or format them as 2 decimal strings
//        String expected = String.format("%.2f", 2.99d * 3);
//        String actual = String.format("%.2f", soup.getPrice());
        assertEquals(expected, actual);
    }
}
