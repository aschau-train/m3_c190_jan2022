/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.meeting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author augie email: aschau@wiley.com date: 2022.02.24 purpose:
 */
@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping
    public String[] helloWorld() {
        String[] result = {"Hello", "World", "!"};
        return result;
    }

    @PostMapping("/calculate")
    public String calculate(int operand1, String operator, int operand2) {
        int result = 0;
        switch (operator) {
            case "plus":
            case "+":
                result = operand1 + operand2;
                break;
            case "minus":
            case "-":
                result = operand1 - operand2;
                break;
            case "times":
            case "*":
                result = operand1 * operand2;
                break;
            case "divide":
            case "/":
                result = operand1 / operand2;
                break;
            default:
                String message = String.format("operator '%s' is invalid", operator);
                throw new IllegalArgumentException(message);
        }
        return String.format("%s %s %s = %s", operand1, operator, operand2, result);
    }

}
