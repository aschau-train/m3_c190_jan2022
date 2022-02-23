/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.meeting.dao;

import com.sg.meeting.models.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author augie email: aschau@wiley.com date: 2022.02.23 purpose:
 */
public class EmployeeDaoDB implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbc;

    private EmployeeMapper employeeMapper = new EmployeeMapper();

    @Override
    public List<Employee> getAllEmployees() {
        final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
        return jdbc.query(SELECT_ALL_EMPLOYEES, employeeMapper);
    }

    @Override
    public Employee getEmployeeById() {
        Employee emp = null;
        try {
            final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
            emp = jdbc.queryForObject(SELECT_EMPLOYEE_BY_ID, employeeMapper);
        } catch (DataAccessException ex) {
            emp = null;
        }
        return emp;
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        final String INSERT_EMPLOYEE = 
                "INSERT INTO employee(firstName, lastName) VALUES (?,?)";
        jdbc.update(INSERT_EMPLOYEE,
                employee.getFirstName(),
                employee.getLastName()
                );
        final String SELECT_NEXT_ID = "SELECT LAST_INSERT_ID()";
        int newId = jdbc.queryForObject(SELECT_NEXT_ID, Integer.class);
        employee.setId(newId);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        final String UPDATE_EMPLOYEE = 
                "UPDATE employee SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getId());
    }

    @Override
    public void deleteEmployeeById(int id) {
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee " 
                + "WHERE employeeid = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, id);
        final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
        jdbc.update(DELETE_EMPLOYEE, id);
    }

    public static final class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirstName(rs.getString("firstName"));
            emp.setLastName(rs.getString("lastName"));
            return emp;
        }

    }

}
