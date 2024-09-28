package com.capstone.service;

import com.capstone.dao.BookingDao;
import com.capstone.entities.BookingEntity;
import com.capstone.model.Booking;
import com.capstone.model.Car;
import com.capstone.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class BookingServiceTest {
    BookingDao bookingDao = mock(BookingDao.class);
    UserService userService = mock(UserService.class);
    CarService carService = mock(CarService.class);

    UUID userId = UUID.randomUUID();
    User user = new User(userId, "foo-bar");
    UUID userId2 = UUID.randomUUID();
    User user2 = new User(userId, "bar-foo");

    String carRegNumber = "erw-3924";
    Car car = new Car(carRegNumber, BigDecimal.TEN,"A7",true);

    UUID expectedBookingId1 = UUID.randomUUID();
    BookingEntity bookingEntity1 = new BookingEntity(expectedBookingId1.toString(), userId.toString(), carRegNumber, "1");

    UUID expectedBookingId2 = UUID.randomUUID();
    BookingEntity bookingEntity2 = new BookingEntity(expectedBookingId2.toString(), userId2.toString(), carRegNumber, "1");

    @Test
    public void shouldGetAllBookings() {
        List<BookingEntity> entities = new ArrayList<>();
        entities.add(bookingEntity1);
        entities.add(bookingEntity2);
        when(bookingDao.getBookings()).thenReturn(entities);

        BookingService bookingService = new BookingService(bookingDao, userService, carService);
        List<Booking> result = bookingService.getBookings();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(expectedBookingId1, result.get(0).getBookingId());
        Assertions.assertEquals(expectedBookingId2, result.get(1).getBookingId());
    }

    @Test
    public void shouldGetOneBooking() {
        when(bookingDao.getBooking(expectedBookingId1)).thenReturn(bookingEntity1);
        when(userService.getUser(userId)).thenReturn(user);
        when(carService.getCar(carRegNumber)).thenReturn(car);

        BookingService bookingService = new BookingService(bookingDao, userService, carService);
        Booking result = bookingService.getBooking(expectedBookingId1.toString());

        Assertions.assertEquals(expectedBookingId1, result.getBookingId());
    }

    @Test
    public void shouldGetOnlyBookingsOfUser() {
        List<BookingEntity> entities = new ArrayList<>();
        entities.add(bookingEntity1);
        entities.add(bookingEntity2);
        when(bookingDao.getBookings()).thenReturn(entities);
        when(userService.getUser(userId2.toString())).thenReturn(user2);
        when(carService.getCar(carRegNumber)).thenReturn(car);

        BookingService bookingService = new BookingService(bookingDao, userService, carService);
        List<Booking> result = bookingService.getBookingsOfUser(userId2);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(userId, result.get(0).getUser().getId());
    }

    @Test
    public void shouldCallBookingDaoCreateBooking() {
        when(userService.getUser(userId.toString())).thenReturn(user);
        when(carService.getCar(carRegNumber)).thenReturn(car);

        BookingService bookingService = new BookingService(bookingDao, userService, carService);
        bookingService.createBooking(userId.toString(), carRegNumber);

        verify(bookingDao, times(1)).createBooking(ArgumentMatchers.any(Booking.class));
    }
}
