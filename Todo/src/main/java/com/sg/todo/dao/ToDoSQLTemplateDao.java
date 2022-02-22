/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.todo.dao;

import com.sg.todo.dto.ToDo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author augie email: aschau@wiley.com date: 2022.02.22 purpose:
 */
public class ToDoSQLTemplateDao {

    @Autowired
    JdbcTemplate jdbc;
    
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        ToDoSQLTemplateDao tds = new ToDoSQLTemplateDao();
        tds.displayList();
    }

    private void displayList() throws SQLException {
        String sql = "SELECT * FROM todo";
        for (ToDo td : jdbc.query(sql, new ToDoMapper())) {
            System.out.printf("%s: %s -- %s -- %s\n",
                    td.getId(),
                    td.getTodo(),
                    td.getNote(),
                    td.isFinished());
        }
        System.out.println("");
    }

    private void addItem() throws SQLException {
        System.out.println("Add Item");
        System.out.println("What is the task?");
        String task = sc.nextLine();
        System.out.println("Any additional notes?");
        String note = sc.nextLine();

        jdbc.update("INSERT INTO todo(todo, note) VALUES(?,?)", task, note);
        System.out.println("Add Complete");
    }

    private static class ToDoMapper implements RowMapper<ToDo> {

        @Override
        public ToDo mapRow(ResultSet rs, int index) throws SQLException {
            ToDo td = new ToDo();
            td.setId(rs.getInt("id"));
            td.setTodo(rs.getString("todo"));
            td.setNote(rs.getString("note"));
            td.setFinished(rs.getBoolean("finished"));
            return td;
        }
    }

}
