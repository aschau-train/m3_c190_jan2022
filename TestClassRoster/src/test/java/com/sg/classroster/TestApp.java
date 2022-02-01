package com.sg.classroster;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.sg.classroster.App;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author augie
 */
public class TestApp {
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void AppHasMainMethod() {
     try {
         Method method = App.class.getMethod("main", String[].class);
         assertNotNull(method);
         return;
     }  catch (NoSuchMethodException ex) {
            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
        }
     fail();
     }
}
