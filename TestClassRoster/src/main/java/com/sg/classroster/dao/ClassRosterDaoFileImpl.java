/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.29
 *purpose:
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    private Map<String, Student> students;
    
    public ClassRosterDaoFileImpl() {
        students =  new HashMap<>();
    }

    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student addStudent(String studentId, Student student) {
        Student prevStudent = students.put(studentId, student);
        return prevStudent;
    }




}
