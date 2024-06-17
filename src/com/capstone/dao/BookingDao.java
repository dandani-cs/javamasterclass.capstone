package com.capstone.dao;

import com.capstone.entities.BookingEntity;
import com.capstone.model.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingDao {
    List<BookingEntity> getBookings();
    BookingEntity getBooking(UUID bookingId);
    List<BookingEntity> getBookingsOfUser(UUID userId);
    Booking createBooking(Booking booking); // TODO: overload with bookingentity
}
