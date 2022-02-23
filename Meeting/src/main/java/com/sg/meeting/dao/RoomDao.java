/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.meeting.dao;

import com.sg.meeting.models.Room;
import java.util.List;

/**
 *
 * @author augie
 */
public interface RoomDao {

    List<Room> getAllRooms();

    Room getRoomById(int id);

    Room addRoom(Room room);

    void updateRoom(Room room);

    void deleteRoomById(int id);
}
