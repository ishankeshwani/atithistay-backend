package com.ishan.AtithiStay.Service;

import com.ishan.AtithiStay.dto.CreateRoomRequest;
import com.ishan.AtithiStay.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoomToHotel(Long hotelId, CreateRoomRequest request);

    List<Room> getRoomsByHotel(Long hotelId);
}
