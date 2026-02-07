package com.ishan.AtithiStay.Service.impl;

import com.ishan.AtithiStay.dto.CreateHotelRequest;
import com.ishan.AtithiStay.Repository.HotelRepository;
import com.ishan.AtithiStay.Service.HotelService;
import com.ishan.AtithiStay.entity.Hotel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public void createHotel(CreateHotelRequest  request) {


        Hotel hotel = new Hotel();
        hotel.setName(request.getName());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());

        hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow(()-> new RuntimeException("Hotel NOt Found with id: "+id));
    }
}
