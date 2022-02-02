/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.controller;

import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author augie
 */
@ExtendWith(MockitoExtension.class)
public class ClassRosterControllerTest {

    @Mock
    ClassRosterServiceLayer service;
    
    @Mock
    ClassRosterView view;
    
    
    
    
    public ClassRosterControllerTest() {
    }
    
    private ClassRosterController controller;
    
    // Mockito Extension will automatically create the two 
    // dependency objects when they are passed to the 
    // ClassRosterController constructor
    @BeforeEach
    public void setUp() {
        controller = new ClassRosterController(service,view);
    }

    /**
     * Test of run method, of class ClassRosterController.
     */
    @Test
    public void testRunIsNotInfiniteLoopWhenGivenValidInput() {
        // ARRANGE
        // To test that the controller.run allows an exit behavior
        // train the mock object "view" to return 5 when
        // printMenuAndGetSelectionIsCalled
        when(view.printMenuAndGetSelection()).thenReturn(5);
        
        // This makes the assumption that someone is watching System.out
        System.out.println("run");
        
        // ACT
        controller.run();
        // ASSERT
        // The run should have called the dependency object view to get
        // the user input.  Confirm that this did happen.
        verify(view).printMenuAndGetSelection();
    }
    
}
