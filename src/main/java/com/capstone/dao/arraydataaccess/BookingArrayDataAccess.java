package com.capstone.dao.arraydataaccess;

import com.capstone.model.Booking;
import com.capstone.service.CarService;
import com.capstone.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookingArrayDataAccess {
    private static final Booking[] bookings = new Booking[100];

    // should be referenced back to service, needed for array init
    private UserService userService;
    private CarService carService;

    private static int size = 2;

    public BookingArrayDataAccess(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
        if (bookings[0] == null) { // check if there is already info there
            bookings[0] = new Booking(UUID.fromString("be00d8b6-f93a-4ad3-a976-38ecd75e6fc7"),
                    userService.getUser("a6a0b0dd-08cb-41b8-9108-682180bab0b9"),
                    carService.getCar("ABC1234"));
            bookings[1] = new Booking(UUID.fromString("8eb90c88-aff9-484e-815d-fa1fdee4d32e"),
                    userService.getUser("d33fe925-515c-4c43-a966-cb74c3b02e3e"),
                    carService.getCar("QWE4534"));
        }
    }

    private static int getSize() {
        return size;
    }

    private static void setSize(int size) {
        BookingArrayDataAccess.size = size;
    }

    public Booking[] getBookings() {
        return Arrays.copyOfRange(bookings, 0, size);
    }

    public Booking getBooking(UUID bookingId) {
        return null;
    }

    public List<Booking> getBookingsOfUser(UUID userId) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking :
                bookings) {
            if (userId.equals(booking.getUser().getId())) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    public Booking createBooking(Booking booking) {
        int initSize = getSize();
        bookings[initSize] = booking;
        setSize(initSize + 1);
        return bookings[initSize];
    }
}
