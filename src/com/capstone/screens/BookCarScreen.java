package com.capstone.screens;

import com.capstone.dao.arraydataaccess.BookingArrayDataAccess;
import com.capstone.service.BookingService;

import java.util.Scanner;

public class BookCarScreen implements IScreen {
    private final BookingService bookingService = new BookingService(new BookingArrayDataAccess());

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user id: ");
        String userid = scanner.next();
        System.out.print("Enter car registration number: ");
        String regNumber = scanner.next();

        try {
            bookingService.createBooking(userid, regNumber);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create booking, ", e);
        }
    }
}
