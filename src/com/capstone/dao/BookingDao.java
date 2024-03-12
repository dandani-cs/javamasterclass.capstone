package com.capstone.dao;

import com.capstone.models.Booking;

import java.util.UUID;

public interface BookingDao {
    Booking[] getBookings();
    Booking getBooking(UUID bookingId);
}
