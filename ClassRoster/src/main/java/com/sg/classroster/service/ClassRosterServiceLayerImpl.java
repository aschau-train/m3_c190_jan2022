/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import java.util.List;


/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.02
 *purpose:
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        // Check the id

        // Reduce calls to getStudentId by caching it
        // String studentId = student.getStudentId();

        if (dao.getStudent(student.getStudentId()) != null){
            throw new ClassRosterDuplicateIdException(
            "ERROR: Could not create student. Student Id " 
                    + student.getStudentId() + " already exists");
        }
            
        validateStudentData(student);
        
        dao.addStudent(student.getStudentId(), student);
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        // removedStudent could potentially be null, but then the 
        // studentId has been removed because it was never there.
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }

    private void validateStudentData(Student student) 
            throws ClassRosterDataValidationException {
        
        // might need to check student is null itself too
        // if (student == null) return;
        
        // if (any string.isBlank() returns true the same
        // rule applies
        if (student.getFirstName() == null ||
                student.getFirstName().length() == 0 ||
                student.getLastName() == null ||
                student.getLastName().length() == 0 ||
                student.getCohort() == null ||
                student.getCohort().length() == 0 )
        {
            throw new ClassRosterDataValidationException(
            "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
