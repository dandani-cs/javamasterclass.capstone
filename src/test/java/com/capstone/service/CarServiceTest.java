package com.capstone.service;

import com.capstone.dao.CarDao;
import com.capstone.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CarServiceTest {
    CarDao carDao = mock(CarDao.class);

    String expectedRegNumber1 = "erw-3924";
    Car mockCar1 = new Car(expectedRegNumber1, BigDecimal.TEN,"A7",true);

    String expectedRegNumber2 = "ied-2439";
    Car mockCar2 = new Car(expectedRegNumber2,BigDecimal.TEN,"Civic",false);

    @Test
    public void shouldGetCarFromRegNumber() {
        when(carDao.getCar(expectedRegNumber1)).thenReturn(mockCar1);

        CarService carService = new CarService(carDao);
        Car result = carService.getCar(expectedRegNumber1);

        Assertions.assertEquals(expectedRegNumber1, result.getRegNumber());
        Assertions.assertEquals(BigDecimal.TEN, result.getRentalRate());
        Assertions.assertEquals("A7", result.getBrand());
        Assertions.assertTrue(result.isElectric());
    }

    @Test
    public void shouldGetAllCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(mockCar1);
        carList.add(mockCar2);
        when(carDao.getCars()).thenReturn(carList);

        CarService carService = new CarService(carDao);
        List<Car> result = carService.getCars();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(expectedRegNumber1, result.get(0).getRegNumber());
        Assertions.assertEquals(expectedRegNumber2, result.get(1).getRegNumber());
    }

    @Test
    public void shouldGetOnlyElectricCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(mockCar1);
        carList.add(mockCar2);
        when(carDao.getCars()).thenReturn(carList);

        CarService carService = new CarService(carDao);
        List<Car> result = carService.getElectricCars();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(expectedRegNumber1, result.get(0).getRegNumber());
    }

    @Test
    public void shouldCallCarDaoCreateCar() throws IOException {
        CarService carService = new CarService(carDao);
        carService.createCar(expectedRegNumber1, BigDecimal.ONE, "Brand", false);
        verify(carDao, times(1)).createCar(ArgumentMatchers.any(Car.class));
    }
}
