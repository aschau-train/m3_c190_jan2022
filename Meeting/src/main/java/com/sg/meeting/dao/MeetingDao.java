/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.meeting.dao;

import com.sg.meeting.models.Employee;
import com.sg.meeting.models.Meeting;
import com.sg.meeting.models.Room;
import java.util.List;

/**
 *
 * @author augie
 */
public interface MeetingDao {
    Meeting getMeetingById(int id);
    List<Meeting> getAllMeetings();
    List<Meeting> getMeetingsForRoom(Room room);
    List<Meeting> getMeetingsForEmployee(Employee employee);
    Meeting addMeeting(Meeting meeting);
    void updateMeeting(Meeting meeting);
    void deleteMeetingById(int id);
}
