package com.capstone.dao.arraydataaccess;

import com.capstone.dao.BookingDao;
import com.capstone.model.Booking;
import com.capstone.service.CarService;
import com.capstone.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingArrayDataAccess implements BookingDao {
    private static final Booking[] bookings;
    private static final UserService userService = new UserService(new UserArrayDataAccess());
    private static final CarService carService = new CarService(new CarArrayDataAccess());

    static {
        bookings = new Booking[] {
                new Booking(UUID.fromString("be00d8b6-f93a-4ad3-a976-38ecd75e6fc7"),
                        userService.getUser("a6a0b0dd-08cb-41b8-9108-682180bab0b9"),
                        carService.getCar("ABC1234")), // TODO: DEPRECATED
                new Booking(UUID.fromString("8eb90c88-aff9-484e-815d-fa1fdee4d32e"),
                        userService.getUser("d33fe925-515c-4c43-a966-cb74c3b02e3e"),
                        carService.getCar("QWE4534"))
        };
    }

    @Override
    public Booking[] getBookings() {
        return bookings;
    }

    @Override
    public Booking getBooking(UUID bookingId) {
        return null;
    }

    @Override
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
}
