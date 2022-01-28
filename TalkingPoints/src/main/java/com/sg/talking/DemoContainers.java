/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.28
 *purpose:
 */
class DemoContainers {

    static void demoContainers(String[] args) {
     
        //BetterCart cart = new BetterCart();
        
        
        GroceryItem item = new Pasta(3);
        
        // A common approach is to store a reference to a container in a
        // variable whose type is the contract (interface) that we are
        // interested in using
        Map<String, GroceryItem> keyValueContainer = new HashMap<String, GroceryItem>();
        
        
        addItemToMap(keyValueContainer, item);
        System.out.println(keyValueContainer.size());
    }

    // By using an interface helper functions can be made more flexible
    // in this case anthing that implements Map<String, GroceryItem> 
    // can be passed to the method
    private static void addItemToMap(Map<String, GroceryItem> keyValueContainer, GroceryItem item) {
        String UPC_Code = "121345676778";
        
       
        if (keyValueContainer.containsKey(UPC_Code)){
            // increment the quantity based on item
            GroceryItem existingItem = keyValueContainer.get(UPC_Code);
            // existingItem.quantity += item.quantity;
            
        }
        else
        {
            // the new key and value
            keyValueContainer.put(UPC_Code, item); 
            
        }
    }

}
