/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.classroster.dao;

import com.sg.classroster.service.ClassRosterPersistenceException;

/**
 *
 * @author augie
 */
public interface ClassRosterAuditDao {
    
    public void writeAuditEntry(String entry) throws
            ClassRosterPersistenceException;
    
}
