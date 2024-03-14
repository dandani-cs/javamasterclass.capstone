package com.capstone.screens;

import com.capstone.models.Booking;
import com.capstone.models.User;
import com.capstone.service.BookingService;
import com.capstone.service.UserService;

import java.util.List;
import java.util.Scanner;

public class BookingByUserScreen implements IScreen {
    private BookingService bookingService;
    private UserService userService;

    public BookingByUserScreen(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user id: ");
        String userId = scanner.next();
        User user = userService.getUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        List<Booking> bookings = bookingService.getBookingsOfUser(user.getId());
        if (bookings.isEmpty()) {
            System.out.println("User has no bookings yet.");
        }
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
