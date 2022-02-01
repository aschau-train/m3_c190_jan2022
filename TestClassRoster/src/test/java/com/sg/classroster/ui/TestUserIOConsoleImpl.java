/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.ui;

import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author augie
 */
public class TestUserIOConsoleImpl {

    private UserIOConsoleImpl userIO;    
    // Dummy the Scanner by passing a string source with the expected value
    // for each test and pass it to the UserIO constructor
    private Scanner cin;
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestUserIOConsoleImplementsUserIO() {
        userIO = new UserIOConsoleImpl();
        assertTrue( userIO instanceof UserIO );
    }
    
     @Test
     public void testReadDouble() {
         cin = new Scanner("2.0");
         userIO = new UserIOConsoleImpl(cin);
         double result = userIO.readDouble("Enter a double");
         assertFalse(Double.isNaN(result));
     }
     
     @Test
     public void testReadDoubleWithRange() {
         cin = new Scanner("2.0");
         userIO = new UserIOConsoleImpl(cin);
         double max = 10.0;
         double min = 1.0;
         String prompt = String.format("Enter a double between %.2f and %.2f",min,max);
         double result = userIO.readDouble(prompt, min, max);
         assertTrue(result >= min);
         assertTrue(result <= max);
     }

    @Test
     public void testReadFloat() {
         cin = new Scanner("2.0");
         userIO = new UserIOConsoleImpl(cin);
         float result = userIO.readFloat("Enter a float");
         assertFalse(Float.isNaN(result));
     }
     
     @Test
     public void testReadFloatWithRange() {
         cin = new Scanner("2.0");
         userIO = new UserIOConsoleImpl(cin);
         float max = 10.0f;
         float min = 1.0f;
         String prompt = String.format("Enter a float between %.2f and %.2f",min,max);
         float result;
         result = userIO.readFloat(prompt, min, max);
         assertTrue(result >= min);
         assertTrue(result <= max);
     }
     
         @Test
     public void testReadInt() {
         cin = new Scanner("2");
         userIO = new UserIOConsoleImpl(cin);
         int result = userIO.readInt("Enter an int");
         assertFalse(result == 0);
     }
     
     @Test
     public void testReadIntWithRange() {
         cin = new Scanner("2");
         userIO = new UserIOConsoleImpl(cin);
         int max = 10;
         int min = 1;
         String prompt = String.format("Enter an int between %d and %d",min,max);
         int result = userIO.readInt(prompt, min, max);
         assertTrue(result >= min);
         assertTrue(result <= max);
     }
     
     @Test
     public void testReadLong() {
         cin = new Scanner("2");
         userIO = new UserIOConsoleImpl(cin);
         long result = userIO.readLong("prompt");
         assertFalse(result == 0);
     }
     
     @Test
     public void testReadLongWithRange() {
         cin = new Scanner("2");
         userIO = new UserIOConsoleImpl(cin);
         long max = 10L;
         long min = 1L;
         String prompt = String.format("Enter a long between %d and %d",min,max);
         long result = userIO.readLong(prompt, min, max);
         assertTrue(result >= min);
         assertTrue(result <= max);
     }
     
     @Test
     public void testReadString(){
         cin = new Scanner("prompt");
         userIO = new UserIOConsoleImpl(cin);
         String result = userIO.readString("prompt");
         assertTrue(result.length() > 0);
     }
}
