package com.capstone.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private User user;
    private Car car;
    private BigDecimal bill;

    public Booking(UUID bookingId, User user, Car car) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;

        this.bill = new BigDecimal(1); // TODO
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
