/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.dao;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import com.sg.classroster.dto.Student;
/**
 *
 * @author augie
 */
public class TestClassRosterDaoFileImpl {
    
    private ClassRosterDao dao;
    
    @BeforeEach
    public void setUp(){
        dao = new ClassRosterDaoFileImpl();
    }
    
    
    @Test
    public void TestAddStudentReturnsPreviousStudent(){
        Student student = new Student("101");
        dao.addStudent(student.getStudentId(), student);
        Student actual = dao.addStudent(student.getStudentId(), student);
        assertEquals(actual.getStudentId(), student.getStudentId());
        
    }

}
