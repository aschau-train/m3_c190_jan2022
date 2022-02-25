package com.sg.todo.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.sg.todo.models.ToDo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToDoInMemoryDaoTest {
    

    @Autowired
    private ToDoDao dao;
    private ToDo firstToDo;

    @BeforeEach
    public void setUp(){
        ToDo todo = new ToDo();
        todo.setTodo("todo test 1");
        todo.setNote("note test 1");
        firstToDo = dao.add(todo);
    }

    @Test
    void testAdd() {
        int startingSize = dao.getAll().size();
        ToDo todo2 = new ToDo();
        todo2.setTodo("todo test 2");
        todo2.setNote("note test 2");
        todo2 = dao.add(todo2);
        assertEquals(dao.getAll().size(),startingSize+1);
    }

    @Test
    void testDeleteById() {
        int goodId = firstToDo.getId();
        dao.deleteById(goodId);
        List<ToDo> todos = dao.getAll();
        assertEquals(todos.size(),0);
    }

    @Test
    void testFindById() {
        int badId = 10;
        ToDo actual = dao.findById(badId);
        assertNull(actual);
    }

    @Test
    void testGetAll() {
        List<ToDo> todos = dao.getAll();
        assertEquals(todos.size(),1);
    }

    @Test
    void testUpdate() {
        int goodId = firstToDo.getId();
        ToDo starterToDo = dao.findById(goodId);
        starterToDo.setFinished(true);
        assertTrue(dao.update(starterToDo));
    }
}
