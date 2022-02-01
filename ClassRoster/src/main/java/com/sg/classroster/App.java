/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
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
public class App {
    public static void main(String[] args) {
        // Define dependency implementations
        
        // Based ENV variable, start args choose impl 
        // UserIO io = new UserIOWebImpl();
        UserIO io = new UserIOConsoleImpl();
        ClassRosterDao dao = new ClassRosterDaoFileImpl();

        // Inject UserIO dependency into ClassRosterView
        ClassRosterView view = new ClassRosterView(io);
        // Inject ClassRosterDao and ClassRosterView into ClassRosterController
        ClassRosterController controller = new ClassRosterController(dao, view);
        
        // Run the application
        controller.run();
    }
}
