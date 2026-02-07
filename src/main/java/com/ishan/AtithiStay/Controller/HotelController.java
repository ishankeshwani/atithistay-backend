package com.ishan.AtithiStay.Controller;


import com.ishan.AtithiStay.dto.CreateHotelRequest;
import com.ishan.AtithiStay.Service.HotelService;
import com.ishan.AtithiStay.entity.Hotel;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public String createHotel(@RequestBody CreateHotelRequest request){
        hotelService.createHotel(request);
        return "Hotel Created Successfully";
    }

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }



}
