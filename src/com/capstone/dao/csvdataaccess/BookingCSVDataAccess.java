package com.capstone.dao.csvdataaccess;

import com.capstone.dao.BookingDao;
import com.capstone.entities.BookingEntity;
import com.capstone.helper.CSVHelper;
import com.capstone.model.Booking;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingCSVDataAccess implements BookingDao {
    private static final String CSV_FILE = "src/resources/Bookings.csv";
    @Override
    public List<BookingEntity> getBookings() {
        return CSVHelper.getData(CSV_FILE).stream()
                .map(this::extractBookingEntity)
                .collect(Collectors.toList());
    }

    private BookingEntity extractBookingEntity(String line) {
        String[] data = line.split(",");
        return new BookingEntity(
                data[0],
                data[1],
                data[2],
                data[3]
        );
    }

    @Override
    public BookingEntity getBooking(UUID bookingId) {
        return CSVHelper.getData(CSV_FILE).stream()
                .filter(line -> bookingId.toString().equals(
                        line.split(",")[0]
                ))
                .findFirst()
                .map(this::extractBookingEntity)
                .orElse(null);
    }

    @Override
    public Booking createBooking(Booking booking) {
        CSVHelper.writeData(CSV_FILE, new BookingEntity(booking).toCSVData());
        return booking;
    }
}
