/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.dto;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @return the cohort
     */
    public String getCohort() {
        return cohort;
    }

    /**
     * @param cohort the cohort to set
     */
    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    

}
