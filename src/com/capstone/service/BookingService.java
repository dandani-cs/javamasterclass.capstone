package com.capstone.service;

import com.capstone.dao.BookingDao;
import com.capstone.model.Booking;
import com.capstone.model.Car;
import com.capstone.model.User;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private final BookingDao bookingDao;
    private final UserService userService;
    private final CarService carService;

    public BookingService(BookingDao bookingDao,
                          UserService userService,
                          CarService carService) {
        this.bookingDao = bookingDao;
        this.userService = userService;
        this.carService = carService;
    }

    public Booking[] getBookings() {
        return bookingDao.getBookings();
    }

    public Booking getBooking(String bookingId) {
        return bookingDao.getBooking(UUID.fromString(bookingId));
    }

    public List<Booking> getBookingsOfUser(UUID userid) {
        return bookingDao.getBookingsOfUser(userid);
    }

    public Booking createBooking(String userId, String carRegNumber) {
        User user = userService.getUser(userId);
        Car car = carService.getCar(carRegNumber);
        if (user == null || car == null) {
            throw new IllegalArgumentException("Invalid booking details");
        }
        return bookingDao.createBooking(new Booking(UUID.randomUUID(), user, car));
    }

    public Booking updateBooking(String userId, String carRegNumber) {
        // TODO
        return null;
    }
}
