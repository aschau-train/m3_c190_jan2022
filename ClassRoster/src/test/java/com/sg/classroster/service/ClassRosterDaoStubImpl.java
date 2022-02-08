/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author augie email: aschau@wiley.com date: 2022.02.08 purpose:
 */
class ClassRosterDaoStubImpl implements ClassRosterDao {

    private Student student;

    public ClassRosterDaoStubImpl() {
        student = new Student("0001") {
            {
                setFirstName("Ada");
                setLastName("Lovelace");
                setCohort("Java-May-1845");
            }
        };
    }

    public ClassRosterDaoStubImpl(Student student) {
        this.student = student;
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        // Bad style of no curly brace on the if block
        if (studentId == this.student.getStudentId()) {
            return this.student;
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return new ArrayList<Student>() {
            {
                add(student);
            }
        };
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        // This is an extreme application of DRY
        return addStudent(studentId, student);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        // A better application of DRY would be a  helper function
        return getOnlyStudent(studentId);
    }

    private Student getOnlyStudent(String studentId) {
        // Bad style of no curly brace on the if block
        if (studentId == student.getStudentId()) {
            return student;
        }
        return null;
    }

}
