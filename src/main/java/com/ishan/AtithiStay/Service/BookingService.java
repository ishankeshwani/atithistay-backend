package com.ishan.AtithiStay.Service;

import com.ishan.AtithiStay.dto.CreateBookingRequest;

public interface BookingService {

    void createBookingRe(CreateBookingRequest request);
    void cancelBooking(Long bookingId);
}
