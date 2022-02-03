/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.talking;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.03
 *purpose:
 */
class EnumsAndDates {

    /**
     * 
     * @param args 
     */
    public static void demo(String[] args) {
        
        // Using an limit set of math operators to determine the appropriate action
        // System.out.println("The answer is = " + calculate(MathOperator.MODULUS, 40, 2));
//        showLocalDate();
        oldDates();
    }
    
    // Play with LocalDate
    private static void showLocalDate(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        
        LocalDate past = localDate.minusWeeks(2);
        System.out.println(past);
        Period diff = localDate.until(past);
        System.out.println(diff);
        Period otherDiff = past.until(localDate);
        System.out.println(otherDiff);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate ld = LocalDate.parse("07.02.2022", formatter);
        System.out.println(ld);
        System.out.println(ld.format(formatter));
        
    }
    
    private static void oldDates(){
        Date date = new Date();
        System.out.println(date);
        ZonedDateTime zdate = ZonedDateTime.ofInstant(
                date.toInstant(),ZoneId.systemDefault());
        System.out.println(zdate);
        LocalDate ld = zdate.toLocalDate();
        System.out.println(ld);
        
    }
    
    
    // Exercise the MathOperator enum
    private static int calculate(MathOperator operator, int operand1, int operand2) {

        switch(operator) {
            case PLUS:
                System.out.println(MathOperator.valueOf("MULTIPLY"));
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            case MODULUS:
                return operand1 % operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }
    
    // Define a limited set of Math operations
    public enum MathOperator {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE, 
        MODULUS
    }
}
