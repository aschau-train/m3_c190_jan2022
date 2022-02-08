/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterPersistenceException;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author augie
 */
public class ClassRosterDaoFileImplTest {

    ClassRosterDao testDao;

    // This method execute before EACH of the @Test methods
    // that makes sure in this case that the testroster.txt 
    // file is always empty at the beginning of any @Test
    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testroster.txt";
        // FileWriter constructor creates or opens the file
        // if no append second argument
        // The next line makes sure the file exists
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetStudent() throws ClassRosterPersistenceException {
        // ARRANGE
        // Create out method test inputs
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");

        // ACT
        // Add the student
        testDao.addStudent(studentId, student);
        Student retrievedStudent = testDao.getStudent(studentId);

        // ASSERT
//        assertEquals(student.getStudentId(), retrievedStudent.getStudentId());
//
//        assertEquals(student.getFirstName(),
//                retrievedStudent.getFirstName(),
//                "Checking student first name.");
//        assertEquals(student.getLastName(),
//                retrievedStudent.getLastName(),
//                "Checking student last name.");
//        assertEquals(student.getCohort(),
//                retrievedStudent.getCohort(),
//                "Checking student cohort.");

        assertEquals(student.getFirstName(), retrievedStudent.getFirstName());
    }

}
