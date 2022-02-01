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
public class TestStudent {
   
    private Student student;
    
    @BeforeEach
    public void setUp(){
        student = new Student("101");
        student.setFirstName("Fred");
        student.setLastName("Flintstone");
        student.setCohort("C190");
    }
    
    @Test
    public void TestStudentId() {
        String expected = "101";
        assertEquals(expected,student.getStudentId());
    }
    
    @Test
    public void TestStudentFirstName() {
        String expected = "Fred";
        assertEquals(expected, student.getFirstName());
    }
    
    @Test
    public void TestStudentLastName() {
        String expected = "Flintstone";
        assertEquals(expected, student.getLastName());
    }
    
    @Test
    public void TestStudentCohort(){
        String expected = "C190";
        assertEquals(expected, student.getCohort());
    }
    
}
