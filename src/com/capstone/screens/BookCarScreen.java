package com.capstone.screens;

import com.capstone.dao.arraydataaccess.BookingArrayDataAccess;
import com.capstone.helper.UserHelper;
import com.capstone.service.BookingService;

import java.util.Scanner;
import java.util.UUID;

public class BookCarScreen implements IScreen {

    private final BookingService bookingService;

    public BookCarScreen(BookingService bookingService) {
        this.bookingService = bookingService;
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
        System.out.print("Enter car registration number: ");
        String regNumber = scanner.next();

        try {
            bookingService.createBooking(userId, regNumber);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create booking, ", e);
        }
    }
}
