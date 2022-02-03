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
class DemoInheritance {

    // An interface is a way of describing a contract for future 
    // realization.  Lets look at an shopping example using Soup
    // and GroceryItem
    static void demoInheritance(String[] args) {
        GroceryItem item = new EconomySoup(3);
  //      double totalCosts = item.getPrice();
  //      System.out.println(String.format("Total cost of items is $%.2f", totalCosts));
        Cart cart = new Cart();
        if (!cart.addItem(item))
        {
            return;  
        }
        System.out.println(item.displayDetails());
        item = new Pasta(6);
        if (!cart.addItem(item))
        {
            return;
        }
        System.out.println(item.displayDetails());
        
        item = new GourmetSoup(2, 3.45f);
        if (!cart.addItem(item))
        {
            return;
        }

        Soup gs = (Soup)item;
        
        System.out.println(gs.demoVirtual());
        
        System.out.println(item.displayDetails());
        
        System.out.println(cart.checkOut());
    }

}
