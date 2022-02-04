/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

import java.math.BigDecimal;
import static java.math.RoundingMode.*;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.03
 *purpose:
 */
class BigDecimalDemo {

    public static void demo(String[] args) {
        BigDecimal a = new BigDecimal("42.34");
//        System.out.println(a);
            // Maybe an array would have been easire
            // then for each to print out
//        BigDecimal[] bigs = new BigDecimal[7];
//        BigDecimal bc = a.setScale(1,CEILING);
//        System.out.println(bc);
//        BigDecimal bd = a.setScale(1,DOWN);
//        System.out.println(bd);
//        BigDecimal bf = a.setScale(1,FLOOR);
//        System.out.println(bf);
//        BigDecimal bhd = a.setScale(1,HALF_DOWN);
//        System.out.println(bhd);
//        BigDecimal bhe = a.setScale(1,HALF_EVEN);
//        System.out.println(bhe);
//        BigDecimal bhu = a.setScale(1,HALF_UP);
//        System.out.println(bhu);
//        BigDecimal bu = a.setScale(1,UP);
//        System.out.println(bu);

        BigDecimal op1 = new BigDecimal("10");
        BigDecimal op2 = new BigDecimal("6");
        BigDecimal c  = op1.divide(op2,5,HALF_UP);
        System.out.println(c);
        double dbd = Double.parseDouble(c.toString());
        System.out.println(dbd);
        
        int x = 10;
        int y = 20;
        int z;
        z = x = y;
        System.out.println(x + " " +  y + " " + z);
        
    }

}
