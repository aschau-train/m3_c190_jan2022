/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.service;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.01
 *purpose:
 */
public class ClassRosterPersistenceException extends Exception {
    
    public ClassRosterPersistenceException(String message){
        super(message);
    }

    public ClassRosterPersistenceException(String message, Throwable cause){
        super(message, cause);
    }

}
