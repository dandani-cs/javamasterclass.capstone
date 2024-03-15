package com.capstone.screens;

import com.capstone.helper.UserHelper;
import com.capstone.model.Booking;
import com.capstone.model.User;
import com.capstone.service.BookingService;
import com.capstone.service.UserService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BookingByUserScreen implements IScreen {
    private BookingService bookingService;
    private UserService userService;

    public BookingByUserScreen(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @Override
    public void display(Scanner scanner) {
        System.out.print("Enter user id: ");
        String userId = scanner.next();
        UUID uuid = UserHelper.extractUserID(userId);
        if (uuid == null) {
            System.out.println("Invalid user id.");
            return;
        }
        User user = userService.getUser(uuid);
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
