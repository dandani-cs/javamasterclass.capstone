package com.capstone.screens;

import com.capstone.model.Booking;
import com.capstone.service.BookingService;

import java.util.Scanner;

public class BookingsScreen implements IScreen {
    private BookingService bookingService;

    public BookingsScreen(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void display(Scanner scanner) {
        Booking[] bookings = bookingService.getBookings();
        for (var booking : bookings) {
            if (booking == null) {
                return;
            }
            System.out.println(booking);
        }
    }
}
