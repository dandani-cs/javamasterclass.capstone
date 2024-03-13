package com.capstone.service;

import com.capstone.dao.BookingDao;
import com.capstone.models.Booking;

import java.util.UUID;

public class BookingService {
    private final BookingDao bookingDao;

    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public Booking[] getBookings() {
        return bookingDao.getBookings();
    }

    public Booking getBooking(String bookingId) {
        return bookingDao.getBooking(UUID.fromString(bookingId));
    }

    public Booking createBooking(String userId, String carRegNumber) {
        // TODO
        // needs validation with dates
        return null;
    }

    public Booking updateBooking(String userId, String carRegNumber) {
        // TODO
        return null;
    }
}
