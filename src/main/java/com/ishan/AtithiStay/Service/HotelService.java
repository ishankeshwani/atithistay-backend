package com.ishan.AtithiStay.Service;


import com.ishan.AtithiStay.dto.CreateHotelRequest;
import com.ishan.AtithiStay.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    void createHotel(CreateHotelRequest createHotelRequest);

    List<Hotel> getAllHotels();

    Hotel getHotelById(Long id);
}
