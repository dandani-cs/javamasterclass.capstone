package com.capstone.entities;

import com.capstone.model.Booking;

import java.math.BigDecimal;

public class BookingEntity {
    public String bookingId;
    public String userid;
    public String carRegNumber;
    public String bill;

    public BookingEntity(String bookingId, String userid, String carRegNumber, String bill) {
        this.bookingId = bookingId;
        this.userid = userid;
        this.carRegNumber = carRegNumber;
        this.bill = bill;
    }

    public BookingEntity(Booking booking) {
        this.bookingId = booking.getBookingId().toString();
        this.userid = booking.getUser().getId().toString();
        this.carRegNumber = booking.getCar().getRegNumber();
        this.bill = BigDecimal.ONE.toString();
    }

    public String toCSVData() {
        return String.join(",", new String[]{bookingId, userid, carRegNumber, bill, "\n"});
    }
}
