/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sg.classroster.dao;

import com.sg.classroster.service.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.31
 *purpose:
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {
    
    // TODO notes show these as pubic, lets see if this causes a problem
    private static final String ROSTER_FILE = "roster.txt";
    private static final String DELIMITER = "::";

    private Map<String, Student> students = new HashMap<>();
    
    @Override
    public Student addStudent(String studentId, Student student)
        throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException{
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    
    private String marshallStudent(Student aStudent){
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842
        String studentAsText = aStudent.getStudentId() + DELIMITER;
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();
        
        return studentAsText;
    }
    
    private Student unmarshallStudent(String studentAsText) throws ClassRosterPersistenceException{
        // studentAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] studentTokens;
        String studentId;
  
        studentTokens = studentAsText.split(DELIMITER);
        // Given th patter above, the student Id is in index 0
        studentId = studentTokens[0];
        
        // Which we can then use to create a new Student object
        Student studentFromFile = new Student(studentId);
        
        // The 3 remaining tokens are need to populate
        // the student object
        try{
            studentFromFile.setFirstName(studentTokens[1]);
            studentFromFile.setLastName(studentTokens[2]);
            studentFromFile.setCohort(studentTokens[3]);
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ClassRosterPersistenceException("Data file contains an empty line", e);
        }
        
        return studentFromFile;
    }
    
    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;
        
        try {
            // Create Scanner for reading from the file
            scanner = new Scanner(
                    new BufferedReader(
                        new FileReader(ROSTER_FILE))
            );
        } catch (FileNotFoundException e){
            throw new ClassRosterPersistenceException(
                    "-_- Could not load data into memory.", e);
        }
        
        // currentline holds the most recent line from the scanner
        String currentLine;
        // currentStudent holds the most recent Student from unmarshalling
        Student currentStudent;
        
        // Go through ROSTER_FILE line by line
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }

    private void writeRoster() throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e){
            throw new ClassRosterPersistenceException("Could not save student data.", e);
        }
        
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList){
            studentAsText = marshallStudent(currentStudent);
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }
}
