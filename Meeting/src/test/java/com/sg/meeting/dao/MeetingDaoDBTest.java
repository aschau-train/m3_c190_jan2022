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
public class MeetingDaoDBTest {
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
     * Test of getMeetingById method, of class MeetingDaoDB.
     */
    @Test
    public void testGetMeetingById() {
        int id = 0;
        Meeting expResult = null;
        Meeting result = meetingDao.getMeetingById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllMeetings method, of class MeetingDaoDB.
     */
    @Test
    public void testGetAllMeetings() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        Meeting meeting2 = new Meeting();
        meeting2.setName("Test Meeting 2");
        meeting2.setTime(LocalDateTime.now().withNano(0));
        meeting2.setRoom(room);
        meeting2.setAttendees(employees);
        meeting2 = meetingDao.addMeeting(meeting2);
        
        List<Meeting> meetings = meetingDao.getAllMeetings();
        
        assertEquals(2, meetings.size());
        assertTrue(meetings.contains(meeting));
        assertTrue(meetings.contains(meeting2));
    }

    /**
     * Test of getMeetingsByRoom method, of class MeetingDaoDB.
     */
    @Test
    public void testGetMeetingsByRoom() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Room room2 = new Room();
        room2.setName("Test Room 2");
        room2.setDescription("Test Room Description 2");
        room2 = roomDao.addRoom(room2);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        Meeting meeting2 = new Meeting();
        meeting2.setName("Test Meeting");
        meeting2.setTime(LocalDateTime.now().withNano(0));
        meeting2.setRoom(room2);
        meeting2.setAttendees(employees);
        meeting2 = meetingDao.addMeeting(meeting2);
        
        Meeting meeting3 = new Meeting();
        meeting3.setName("Test Meeting");
        meeting3.setTime(LocalDateTime.now().withNano(0));
        meeting3.setRoom(room);
        meeting3.setAttendees(employees);
        meeting3 = meetingDao.addMeeting(meeting3);
        
        List<Meeting> meetingsForRoom = meetingDao.getMeetingsForRoom(room);
        
        assertEquals(2, meetingsForRoom.size());
        assertTrue(meetingsForRoom.contains(meeting));
        assertTrue(meetingsForRoom.contains(meeting3));
        assertFalse(meetingsForRoom.contains(meeting2));
    }

    /**
     * Test of getMeetingsForEmployee method, of class MeetingDaoDB.
     */
    @Test
    public void testGetMeetingsForEmployee() {
        
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2 = employeeDao.addEmployee(employee2);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        
        List<Employee> employees2 = new ArrayList<>();
        employees2.add(employee2);
        
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        Meeting meeting2 = new Meeting();
        meeting2.setName("Test Meeting");
        meeting2.setTime(LocalDateTime.now().withNano(0));
        meeting2.setRoom(room);
        meeting2.setAttendees(employees2);
        meeting2 = meetingDao.addMeeting(meeting2);
        
        Meeting meeting3 = new Meeting();
        meeting3.setName("Test Meeting");
        meeting3.setTime(LocalDateTime.now().withNano(0));
        meeting3.setRoom(room);
        meeting3.setAttendees(employees);
        meeting3 = meetingDao.addMeeting(meeting3);
        
        List<Meeting> meetingsForEmployee = meetingDao.getMeetingsForEmployee(employee);
        
        assertEquals(2, meetingsForEmployee.size());
        assertTrue(meetingsForEmployee.contains(meeting));
        assertTrue(meetingsForEmployee.contains(meeting3));
        assertFalse(meetingsForEmployee.contains(meeting2));
    }

    /**
     * Test of addMeeting method, of class MeetingDaoDB.
     */
    @Test
    public void testAddGetMeeting() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);

        Meeting fromDao = meetingDao.getMeetingById(meeting.getId());

        assertEquals(meeting, fromDao);
    }

    /**
     * Test of updateMeeting method, of class MeetingDaoDB.
     */
    @Test
    public void testUpdateMeeting() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        Meeting fromDao = meetingDao.getMeetingById(meeting.getId());

        assertEquals(meeting, fromDao);
        
        meeting.setName("Test Meeting 2");
        
        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2 = employeeDao.addEmployee(employee2);
        
        employees.add(employee2);
        
        meeting.setAttendees(employees);
        
        meetingDao.updateMeeting(meeting);
        
        assertNotEquals(meeting, fromDao);
        
        fromDao = meetingDao.getMeetingById(meeting.getId());

        assertEquals(meeting, fromDao);
    }

    /**
     * Test of deleteMeetingById method, of class MeetingDaoDB.
     */
    @Test
    public void testDeleteMeetingById() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        meetingDao.deleteMeetingById(meeting.getId());
        
        Meeting fromDao = meetingDao.getMeetingById(meeting.getId());
        
        assertNull(fromDao);
    }
    
}
