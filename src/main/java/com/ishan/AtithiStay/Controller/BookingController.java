package com.ishan.AtithiStay.Controller;


import com.ishan.AtithiStay.Service.BookingService;
import com.ishan.AtithiStay.dto.CreateBookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public String createBooking(@RequestBody CreateBookingRequest request){
        bookingService.createBookingRe(request);
        return "Booking Confirmed Succesfully";
    }

    @PutMapping("/{bookingId}/cancel")
    public String cancelBooking(@PathVariable Long bookingId){
        bookingService.cancelBooking(bookingId);
        return "Booking Cancelled Successfully";
    }

}
