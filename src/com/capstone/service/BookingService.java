package com.capstone.service;

import com.capstone.dao.BookingDao;
import com.capstone.entities.BookingEntity;
import com.capstone.model.Booking;
import com.capstone.model.Car;
import com.capstone.model.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Booking> getBookings() { // TODO: display something if no booking is saved
        return bookingDao.getBookings().stream()
                .map(this::fromBookingEntity)
                .collect(Collectors.toList());
    }

    public Booking getBooking(String bookingId) {
        return fromBookingEntity(bookingDao.getBooking(UUID.fromString(bookingId)));
    }

    public List<Booking> getBookingsOfUser(UUID userid) {
        return bookingDao.getBookings().stream()
                .filter(entity -> userid.toString().equals(entity.userid))
                .map(this::fromBookingEntity)
                .collect(Collectors.toList());
    }

    public Booking createBooking(String userId, String carRegNumber) {
        User user = userService.getUser(userId);
        Car car = carService.getCar(carRegNumber);
        if (user == null || car == null) {
            throw new IllegalArgumentException("Invalid booking details");
        }
        return bookingDao.createBooking(new Booking(UUID.randomUUID(), user, car)); // TODO: maybe just pass userid and carReg?
    }

    private Booking fromBookingEntity(BookingEntity entity) {
        return new Booking(
                UUID.fromString(entity.bookingId),
                userService.getUser(entity.userid),
                carService.getCar(entity.carRegNumber)
        );
    }

    public Booking updateBooking(String userId, String carRegNumber) {
        // TODO
        return null;
    }
}
