/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.meeting.dao;

import com.sg.meeting.models.Employee;
import java.util.List;

/**
 *
 * @author augie
 */
public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(int id);            
}
