package com.ishan.AtithiStay.Controller;


import com.ishan.AtithiStay.Service.RoomService;
import com.ishan.AtithiStay.dto.CreateRoomRequest;
import com.ishan.AtithiStay.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels/{hotelId}/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public String addRoom(
            @PathVariable Long hotelId,
            @RequestBody CreateRoomRequest request){
        roomService.addRoomToHotel(hotelId, request);
        return "Room Created Successfully !!";
    }

    @GetMapping
    public List<Room> getRooms(@PathVariable Long hotelId){
        return  roomService.getRoomsByHotel(hotelId);
    }

}
