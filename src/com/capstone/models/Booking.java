package com.capstone.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private User user;
    private Car car;
    private BigDecimal bill;
    private Date startDate;
    private Date endDate;

    public Booking(UUID bookingId, User user, Car car, Date startDate, Date endDate) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;

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
