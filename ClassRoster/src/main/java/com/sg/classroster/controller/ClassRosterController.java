/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class ClassRosterController {

    private UserIO io = new UserIOConsoleImpl();
    private ClassRosterView view;
    private ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public ClassRosterController() {
        this.view = new ClassRosterView();
    }
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing){
// Step 1 everything in Controller
//            io.print("Main Menu");
//            io.print("1. List Student IDs");
//            io.print("2. Create New Student");
//            io.print("3. View a Student");
//            io.print("4. Remove a Student");
//            io.print("5. Exit");
//            
//            menuSelection = io.readInt("Please select from the"
//                        + " above choice.", 1,5);
            
            menuSelection = getMenuSelection();

            switch(menuSelection){
                case 1:
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
            }
        }
        io.print("GOOD BYE");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent =  view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
    }
    
    
}
