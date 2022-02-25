package com.sg.meeting.dao;

import com.sg.meeting.TestApplicationConfiguration;
import com.sg.meeting.models.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author augie
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class EmployeeDaoDBTest {
    
    @Autowired
    RoomDao roomDao;
    
    @Autowired
    EmployeeDao employeeDao;
    
    @Autowired
    MeetingDao meetingDao;
    
    @BeforeEach
    public void setUp() {
        // Loop through all the rooms and remove them
        // from the storage
        for (Room room : roomDao.getAllRooms())
        {
            roomDao.deleteRoomById(room.getId());
        }
        // Loop through all the other entities and remove them
        // from the storage
        for (Employee employee : employeeDao.getAllEmployees()){
            employeeDao.deleteEmployeeById(employee.getId());
        }
        for(Meeting meeting : meetingDao.getAllMeetings()){
            meetingDao.deleteMeetingById(meeting.getId());
        }
        
    }

    /**
     * Test of getAllEmployees method, of class EmployeeDaoDB.
     */
    @Test
    public void testGetAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2 = employeeDao.addEmployee(employee2);

        List<Employee> employees = employeeDao.getAllEmployees();

        assertEquals(2, employees.size());
        assertTrue(employees.contains(employee));
        assertTrue(employees.contains(employee2));
    }

    /**
     * Test of getEmployeeById method, of class EmployeeDaoDB.
     */
    @Test
    public void testAddGetEmployeeById() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);

        Employee fromDao = employeeDao.getEmployeeById(employee.getId());
        
        assertEquals(employee, fromDao);
    }


    /**
     * Test of updateEmployee method, of class EmployeeDaoDB.
     */
    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        final int sharedId = employee.getId();
        Employee fromDao = employeeDao.getEmployeeById(sharedId);
        
        
//        assertEquals(employee, fromDao);
        
        employee.setFirstName("Another Test First");
        
        employeeDao.updateEmployee(employee);
        
        assertNotEquals(employee, fromDao, "The original and updated records match - incorrectly");
        
        fromDao = employeeDao.getEmployeeById(sharedId);
        
        assertEquals(employee, fromDao, "The updated and current records don't match - incorrectly");
    }

    /**
     * Test of deleteEmployeeById method, of class EmployeeDaoDB.
     */
    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now());
        meeting.setRoom(room);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        employeeDao.deleteEmployeeById(employee.getId());
        
        Employee fromDao = employeeDao.getEmployeeById(employee.getId());
        
        assertNull(fromDao);
    }
    
}
