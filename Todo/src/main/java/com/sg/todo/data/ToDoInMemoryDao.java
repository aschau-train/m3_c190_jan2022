
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.todo.data;

import com.sg.todo.models.ToDo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.25
 *purpose:
 */
@Repository
@Profile("memory")
public class ToDoInMemoryDao implements ToDoDao {

    private static final List<ToDo> todos = new ArrayList();
    // Optionally store in memory as a map keyed to the Todo ID
    // private static final Map<int, ToDo> todos = new HashMap();
    
    // Need to load this on startup after shutdown
    private static int nextId = 1;
    
    @Override
    public ToDo add(ToDo todo) {
        todo.setId(getNextId());
        todos.add(todo);
        return todo;
    }

    @Override
    public List<ToDo> getAll() {
        // return todos; // Don't give access to the private data
        // give them a copy
        return new ArrayList<ToDo>(todos);
    }

    @Override
    public ToDo findById(int id) {
        return todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean update(ToDo todo) {
        int index = 0;
        
        while (index < todos.size()
                && todos.get(index).getId() != todo.getId()) {
            index++;
        }

        if (index < todos.size()) {
            todos.set(index, todo);
        }
        return index < todos.size();
        
    }

    @Override
    public boolean deleteById(int id) {
        return todos.removeIf(i -> i.getId() == id);
    }

    private int getNextId() {
//        int nextId = todos.stream().mapToInt(i -> i.getId())
//                .max()
//                .orElse(0) + 1;
        
        return nextId++;
    }

}
