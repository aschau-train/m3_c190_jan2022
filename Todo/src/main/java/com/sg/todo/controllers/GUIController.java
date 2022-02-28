/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.todo.controllers;

import com.sg.todo.models.ToDo;
import com.sg.todo.services.ToDoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.27
 *purpose:
 */
@Controller
public class GUIController {

    @Autowired
    ToDoService service;
    
    @GetMapping("todos")
    public String displayTodos(Model model){
        model.addAttribute("todos", service.getAll());
        return "todos";
    }
    
    @PostMapping("addTodo")
    public String addToDo(HttpServletRequest request){
        String todo = request.getParameter("todo");
        String note = request.getParameter("note");
        ToDo newToDo = new ToDo();
        newToDo.setTodo(todo);
        newToDo.setNote(note);
        service.add(newToDo);
        return "redirect:/todos";
        
    }
    
    @GetMapping("deleteTodo")
    public String deleteTodo(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        return "redirect:/todos";
    }
    
    
    @GetMapping("editTodo")
    public String editTodo(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        ToDo todo = service.findById(id);
        model.addAttribute("todo", todo);
        return "editTodo";
    }
    
    @PostMapping("editTodo")
    public String performEditTodo(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        ToDo updatedToDo = service.findById(id);

        updatedToDo.setTodo(request.getParameter("todo"));
        updatedToDo.setNote(request.getParameter("note"));
        // The boolean is either 'on' or null
        boolean bFinished = request.getParameter("finished") !=  null && request.getParameter("finished").equals("on");
        updatedToDo.setFinished(bFinished);

        service.update(updatedToDo);

        return "redirect:/todos";
    }
}
