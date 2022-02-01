/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.controller;

import com.sg.classroster.ui.UserIO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author augie
 */
@ExtendWith(MockitoExtension.class)
public class TestClassRosterController {
    
    @Mock
    private UserIO io;
    
    private ClassRosterController controller;
    
    @BeforeEach
    public void setUp(){
        // Set the mock to exit the loop and count the number of print() calls
        when(io.readInt("Please select from the above choices.",1,5)).thenReturn(5);
        controller = new ClassRosterController(io);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testUserIOPrintIsCalled() {
        controller.run();
        Mockito.verify(io,times(7)).print(ArgumentMatchers.any(String.class));
     }
}
