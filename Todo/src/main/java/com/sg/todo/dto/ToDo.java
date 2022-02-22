/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.todo.dto;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.22
 *purpose:
 */
public class ToDo {

    private int id;
    private String todo;
    private String note;
    private boolean finished;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the todo
     */
    public String getTodo() {
        return todo;
    }

    /**
     * @param todo the todo to set
     */
    public void setTodo(String todo) {
        this.todo = todo;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    


}
