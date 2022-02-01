/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.dto;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.29
 *purpose:
 */
public class Student {

    private final String studentId;
    private String firstName = "";
    private String lastName = "";
    private String cohort = "";

    public Student(String studentId) {
        this.studentId = studentId;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    public String getCohort() {
        return cohort;
    }

}
