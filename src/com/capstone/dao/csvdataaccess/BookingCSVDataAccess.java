package com.capstone.dao.csvdataaccess;

import com.capstone.dao.BookingDao;
import com.capstone.entities.BookingEntity;
import com.capstone.model.Booking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BookingCSVDataAccess implements BookingDao {
    private static final String CSV_FILE = "src/resources/Bookings.csv";
    @Override
    public List<BookingEntity> getBookings() {
        List<BookingEntity> bookings = new ArrayList<>();
        try (Scanner csvScanner = new Scanner(new File(CSV_FILE))) { // TODO: check if file exists, if not create
            while (csvScanner.hasNextLine()) {
                bookings.add(extractBookingEntity(csvScanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bookings;
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
        String id = bookingId.toString();
        try (Scanner csvScanner = new Scanner(new File(CSV_FILE))) {
            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                String[] data = line.split(",");
                if (id.equals(data[0])) {
                    return extractBookingEntity(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + CSV_FILE + " was not found", e);
        }
        return null;
    }

    @Override
    public List<BookingEntity> getBookingsOfUser(UUID userId) {
        List<BookingEntity> bookings = new ArrayList<>();
        String id = userId.toString();
        try (Scanner csvScanner = new Scanner(new File(CSV_FILE))) {
            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                String[] data = line.split(",");
                if (id.equals(data[1])) {
                    bookings.add(extractBookingEntity(line));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + CSV_FILE + " was not found", e);
        }
        return bookings;
    }

    @Override
    public Booking createBooking(Booking booking) {
        try (FileWriter fileWriter = new FileWriter(CSV_FILE, true)) {
            BookingEntity entity = new BookingEntity(booking);
            fileWriter.append(entity.toCSVData());
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be opened");
        }
        return booking;
    }
}
