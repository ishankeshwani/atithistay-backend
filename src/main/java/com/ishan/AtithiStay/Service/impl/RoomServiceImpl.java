package com.ishan.AtithiStay.Service.impl;

import com.ishan.AtithiStay.Repository.HotelRepository;
import com.ishan.AtithiStay.Repository.RoomRepository;
import com.ishan.AtithiStay.Service.RoomService;
import com.ishan.AtithiStay.dto.CreateRoomRequest;
import com.ishan.AtithiStay.entity.Hotel;
import com.ishan.AtithiStay.entity.Room;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private  final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;


    @Override
    public void addRoomToHotel(Long hotelId, CreateRoomRequest request) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));

        Room room = new Room();
        room.setRoomNumber(request.getRoomNumber());
        room.setPrice(request.getPrice());
        room.setCapacity(request.getCapacity());
        room.setHotel(hotel);

        roomRepository.save(room);

    }

    @Override
    public List<Room> getRoomsByHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
}
