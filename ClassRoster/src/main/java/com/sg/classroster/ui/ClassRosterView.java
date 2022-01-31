/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class ClassRosterView {
    
    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
    
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the"
                    + " above choice.", 1,5);
    }
    
    public Student getNewStudentInfo(){
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter FIrst Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        
        return currentStudent;
    }
    
    public void displayCreateStudentBanner(){
        io.print("=== Create Student ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("Student successfully created. Please press enter to continue");
    }
}
