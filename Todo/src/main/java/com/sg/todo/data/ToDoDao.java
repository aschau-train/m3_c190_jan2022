/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.todo.data;

import com.sg.todo.models.ToDo;
import java.util.List;

/**
 *
 * @author augie
 */
public interface ToDoDao {
    //CRUD
    // Return the completed todo with id
    ToDo add(ToDo todo);
    
    List<ToDo> getAll();
    
    // Return individual ToDo or null
    ToDo findById(int id);
    
    // true if item exists AND is updated
    boolean update(ToDo todo);
    
    // true if items exists AND is deleted
    boolean deleteById(int id);
    
}
