/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.dto;

import java.util.Objects;

/**
 *
 * @author augie email: aschau@wiley.com date: 2022.01.31 purpose:
 */
public class Student { // implicitly extends Object

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        // To workaround problems with Runtime Class being slight different
        // int getClass()
        if (o == null  || !(o instanceof Student)){
            return false;
        }
        
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) 
                && Objects.equals(firstName, student.firstName) 
                && Objects.equals(lastName, student.lastName) 
                && Objects.equals(cohort, student.cohort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, cohort);
    }

//    @Override
//    public int hashCode(){
//        int hash = 7;
//        hash = 89 * hash + Objects.hashCode(this.firstName);
//        hash = 89 * hash + Objects.hashCode(this.lastName);
//        hash = 89 * hash + Objects.hashCode(this.studentId);
//        hash = 89 * hash + Objects.hashCode(this.cohort);
//        return hash;
//    }
//    
////    public static boolean equals(Student student1, Student student2){
////        return student1.equals(student2);
////    }
//    
//    @Override
//    public boolean equals(Object obj){
//        if (obj == this){
//            return true;
//        }
//        if (obj == null){
//            return false;
//        }
//        if (getClass() != obj.getClass())
//        {
//            return false;
//        }
//        final Student other = (Student)obj;
////        if (!Objects.equals(this.firstName, other.firstName)){
////            return false;
////        }
////        if (!Objects.equals(this.lastName, other.lastName)){
////            return false;
////        }
////        if (!Objects.equals(this.studentId, other.studentId)){
////            return false;
////        }
////        if (!Objects.equals(this.cohort, other.cohort)){
////            return false;
////        }
//        if (this.firstName != other.firstName){
//            return false;
//        }
//        if (this.lastName != other.lastName) {
//            return false;
//        }
//        if (this.cohort != other.cohort){
//            return false;
//        }
//        if (this.studentId != other.studentId){
//            return false;
//        }
//        return true;   
//    }
    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName
                + ", lastName=" + lastName
                + ", studentId=" + studentId
                + ", cohort=" + cohort;

    }

}
