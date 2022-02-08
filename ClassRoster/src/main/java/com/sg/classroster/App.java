/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.service.*;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class App {

    public static void main(String[] args) {
//        // Define dependency implementations
//        
//        // Based ENV variable, start args choose impl 
//        // UserIO io = new UserIOWebImpl();
//        UserIO io = new UserIOConsoleImpl();
//        ClassRosterDao dao = new ClassRosterDaoFileImpl();
//        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoFileImpl();
//        ClassRosterServiceLayer service = new ClassRosterServiceLayerImpl(dao, auditDao);
//
//        // Inject UserIO dependency into ClassRosterView
//        ClassRosterView view = new ClassRosterView(io);
//        // Inject ClassRosterDao and ClassRosterView into ClassRosterController
//        ClassRosterController controller = new ClassRosterController(service, view);
//        
//        // Run the application
//        controller.run();

        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Not that we want the service but to demonstrate that the second argument is the 'class'
        // or 'type' of the object being returned - sometimes an type of interface
        // ClassRosterServiceLayer layer = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class)
        
        ClassRosterController controller = 
                ctx.getBean("controller", ClassRosterController.class);
        controller.run();

    }
}
