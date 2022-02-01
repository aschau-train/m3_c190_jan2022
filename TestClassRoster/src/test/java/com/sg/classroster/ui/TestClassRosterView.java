/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author augie
 */
@ExtendWith(MockitoExtension.class)
public class TestClassRosterView {
    
    private ClassRosterView view;
    
    @Mock
    UserIO io;
    
    @BeforeEach
    public void setUp(){
        view = new ClassRosterView(io);
    }
    
    @Test
    public void testPrintMenuAndGetSelectionReturnsInput() {
        int expected = 5;
        when(io.readInt("Please select from the above choices.",1,5)).thenReturn(expected);
        int actual = view.printMenuAndGetSelection();
        assertEquals(expected,actual);
    }
    
    @Test
    public void testGetNewStudentInfo(){
        doReturn("101").when(io).readString("Please enter Student ID");
        doReturn("Fred").when(io).readString("Please enter First Name");
        doReturn("Flintstone").when(io).readString("Please enter Last Name");
        doReturn("C190").when(io).readString("Please enter Cohort");
        Student expected = new Student("101");
        expected.setFirstName("Fred");
        expected.setLastName("Flintstone");
        expected.setCohort("C190");
        assertEquals(expected.getStudentId(), (view.getNewStudentInfo()).getStudentId());   
    }
    
    @Test
    @Disabled
    public void testDisplayCreateStudentBannerCalled(){
        view.displayCreateStudentBanner();
    }
    
    @Test
    @Disabled
    public void testDisplayCreateStudentSuccessBannerCalled(){
        view.displayCreateSuccessBanner();
    }
    
    @Test
    @Disabled
    public void testDisplayStudentListCalled(){
        view.displayStudentList(new ArrayList<Student>());
    }

    @Test
    @Disabled
    public void testDisplayAllBannerCalled(){
        view.displayDisplayAllBanner();
    }
    
}
