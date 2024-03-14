package com.capstone.dao;

import com.capstone.models.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingDao {
    Booking[] getBookings();
    Booking getBooking(UUID bookingId);
    List<Booking> getBookingsOfUser(UUID userId);
}
