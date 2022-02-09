/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.sg.classroster.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author augie
 */
public class StudentTest {

    private Student expectedStudent;
    
    @BeforeEach
    public void setUp(){
        expectedStudent = new Student("1001"){{
            setFirstName("Ada");
            setLastName("Lovelace");
            setCohort("Java-May-1845");
        }};
    }
    
    @Test
    public void testStudentEqualityDoesNotDependOnAddress() {
        Student actualStudent = new Student("1001"){{
            setFirstName("Ada");
            setLastName("Lovelace");
            setCohort("Java-May-1845");
        }};
        assertTrue(actualStudent.equals(expectedStudent));
        
    }
    
}
