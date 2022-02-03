/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

import java.util.*;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.28
 *purpose:
 */
class BetterCart {
    
    private List<GroceryItem> contents = new ArrayList<GroceryItem>();
    //private Stack<String> strings = new Stack<String>();
    
//    public void testMethod(){
//        strings.push("hello");
//        String value = strings.pop();
//    }

    public boolean addItem(GroceryItem item){
        return contents.add(item);
    }
    
    public String checkOut(){
        return String.format("%d items in the cart", contents.size());
    }
    
    public void emptyCart() {
        contents.clear();
    }


    public void Helper(Collection<GroceryItem> coll){
        if (!coll.isEmpty()){
            for (GroceryItem item : coll){
                System.out.println(item.displayDetails());
            }
        }
    }
    
    
}
