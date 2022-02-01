/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.29
 *purpose:
 */
public interface ClassRosterDao {

    public List<Student> getAllStudent();

    public Student addStudent(String studentId, Student student);

}
