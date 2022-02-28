package com.sg.todo.services;

import java.util.List;

import com.sg.todo.data.ToDoDao;
import com.sg.todo.models.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    ToDoDao dao;
    
    public List<ToDo> getAll(){
        return dao.getAll();    
    }

    public ToDo findById(int id) {
        return dao.findById(id);
    }
    
    public boolean update(ToDo todo){
        return dao.update(todo);
    }
    
    public ToDo add(ToDo todo){
        return dao.add(todo);
    }
    
    public boolean delete(int id){
        return dao.deleteById(id);
    }
}
