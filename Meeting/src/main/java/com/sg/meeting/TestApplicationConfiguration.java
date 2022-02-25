/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.meeting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;


/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.02.24
 *purpose:
 */
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        value = CommandLineRunner.class))
@EnableAutoConfiguration
public class TestApplicationConfiguration {

}
