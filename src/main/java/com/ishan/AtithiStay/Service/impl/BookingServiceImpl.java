package com.ishan.AtithiStay.Service.impl;

import com.ishan.AtithiStay.Repository.BookingRepository;
import com.ishan.AtithiStay.Repository.RoomRepository;
import com.ishan.AtithiStay.Repository.UserRepository;
import com.ishan.AtithiStay.Service.BookingService;
import com.ishan.AtithiStay.dto.CreateBookingRequest;
import com.ishan.AtithiStay.entity.Booking;
import com.ishan.AtithiStay.entity.BookingStatus;
import com.ishan.AtithiStay.entity.Room;
import com.ishan.AtithiStay.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional


public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;


    @Override
    public void createBookingRe(CreateBookingRequest request) {

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(()-> new RuntimeException("Room NOt Fund With Id: "));

        User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("User Not Found"));

        // Overlap Check
        List<Booking> overlaps =
                bookingRepository.findOverlappingBookings(
                        room.getId(),
                        request.getCheckInDate(),
                        request.getCheckOutDate()
                );
        if(!overlaps.isEmpty()){
            throw new RuntimeException("Room IS Already Booked For Selected dates");
        }

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setUser(user);
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setStatus(BookingStatus.CONFIRMED);

        bookingRepository.save(booking);

    }

    @Override
    @Transactional
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking Not found"));

        booking.setStatus(BookingStatus.CANCELLED);
    }
}
