package com.capstone.model;

import java.math.BigDecimal;
import java.util.Objects;
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

        this.bill = BigDecimal.ONE; // TODO
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (!Objects.equals(bookingId, booking.bookingId)) return false;
        if (!Objects.equals(user, booking.user)) return false;
        if (!Objects.equals(car, booking.car)) return false;
        return Objects.equals(bill, booking.bill);
    }

    @Override
    public int hashCode() {
        int result = bookingId != null ? bookingId.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        result = 31 * result + (bill != null ? bill.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", bill=" + bill +
                '}';
    }
}
