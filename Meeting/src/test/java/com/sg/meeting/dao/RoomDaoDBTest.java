
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
public class RoomDaoDBTest {
    
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
     * Test of getAllRooms method, of class RoomDaoDB.
     */
    @Test
    public void testGetAllRooms() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Room room2 = new Room();
        room2.setName("Test Room 2");
        room2.setDescription("Test Room 2");
        room2 = roomDao.addRoom(room2);
        
        List<Room> rooms = roomDao.getAllRooms();
        
        assertEquals(2, rooms.size());
        assertTrue(rooms.contains(room));
        assertTrue(rooms.contains(room2));
    }

    /**
     * Test of getRoomById method, of class RoomDaoDB.
     */
    @Test
    public void testGetRoomById() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        int newId = roomDao.addRoom(room).getId();
        int result = roomDao.getRoomById(newId).getId();
        assertEquals(newId, result);
    }

    /**
     * Test of addRoom method, of class RoomDaoDB.
     */
    @Test
    public void testAddGetRoom() {
        // Arrange
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Descriptoin");
        Room expResult = room;
        // Act
        Room result = roomDao.addRoom(room);
        // Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of updateRoom method, of class RoomDaoDB.
     */
    @Test
    public void testUpdateRoom() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Room fromDao = roomDao.getRoomById(room.getId());
        
        assertEquals(room, fromDao);
        
        room.setName("Another Test Room");
        
        roomDao.updateRoom(room);
        
        assertNotEquals(room, fromDao);
        
        fromDao = roomDao.getRoomById(room.getId());
        
        assertEquals(room, fromDao);
    }

    /**
     * Test of deleteRoomById method, of class RoomDaoDB.
     */
    @Test
    public void testDeleteRoom() {
        // Arrange
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now());
        meeting.setRoom(room);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        // Act
        roomDao.deleteRoomById(room.getId());

        // Assert
        Room fromDao = roomDao.getRoomById(room.getId());
        assertNull(fromDao);
    }
    
}
