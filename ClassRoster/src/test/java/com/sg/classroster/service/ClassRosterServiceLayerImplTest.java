/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author augie
 */
public class ClassRosterServiceLayerImplTest {

    private ClassRosterAuditDao auditDao;
    private ClassRosterDao dao;
    private ClassRosterServiceLayer service;

    @BeforeEach
    public void setUp() {
        auditDao = new ClassRosterAuditDaoStubImpl();
        dao = new ClassRosterDaoStubImpl();
        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }

    /**
     * Test of createStudent method, of class ClassRosterServiceLayerImpl.
     */
    @Test
    public void testCreateInvalidStudent() {
        System.out.println("createStudent");
        Student student = null;
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException ex) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (ClassRosterDataValidationException ex) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (ClassRosterPersistenceException ex) {
            Logger.getLogger(ClassRosterServiceLayerImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testCreateDuplicateIdStudent() {
        // ARRANGE
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
            fail("Expected DupeId Exception was not thrown.");
        } catch (ClassRosterDataValidationException
                | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of createStudent method, of class ClassRosterServiceLayerImpl with
     * valid student
     */
    @Test
    public void testCreateValidStudent() {
        // ARRANGE
        Student student = new Student("0002") {
            {
                setFirstName("Charles");
                setLastName("Babbage");
                setCohort(".NET-May-1845");
            }
        };

        // ACT
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException | ClassRosterPersistenceException ex) {
            Logger.getLogger(ClassRosterServiceLayerImplTest.class.getName()).log(Level.SEVERE, null, ex);
            // ASSERT
            fail("Student was valid. No exception should have been thrown.");
        }
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayerImpl.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT 
        var container = service.getAllStudents();
        Student contains = container.get(0);
        // ASSERT

        assertEquals(1, container.size(),
                "Should only have one student.");

        assertTrue(contains.equals(testClone),
                "The one student should be Ada.");
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayerImpl.
     */
    @Test
    public void testGetStudentValidId() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT 
        Student shouldBeAda = service.getStudent("0001");

        // ASSERT
        assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
        assertEquals(testClone.getFirstName(), shouldBeAda.getFirstName(),
                "Student stored under 0001 should be Ada.");

    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayerImpl. with
     * invalid id
     */
    @Test
    public void testGetStudentInvalidId() throws Exception {
        // ARRANGE & ACT
        Student shouldBeNull = service.getStudent("0042");
        assertNull(shouldBeNull, "Getting 0042 should be null.");
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayerImpl.
     */
    @Test
    public void testRemoveStudentValidId() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT 
        Student shouldBeAda = service.removeStudent("0001");

    }

    @Test
    public void testRemoveStudentInvalidId() throws Exception {
        // ARRANGE & ACT
        Student shouldBeNull = service.removeStudent("0042");
        // ASSERT
        assertNull(shouldBeNull, "Removing 0042 should be null.");
    }

}
