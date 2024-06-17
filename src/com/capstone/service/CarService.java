package com.capstone.service;

import com.capstone.dao.CarDao;
import com.capstone.model.Car;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public ArrayList<Car> getCars() {
        return carDao.getCars();
    }

    public List<Car> getElectricCars() {
        return carDao.getCars().stream()
                .filter(Car::isElectric)
                .collect(Collectors.toList());
    }

    public Car getCar(String regNumber) {
        return carDao.getCar(regNumber);
    }

    public Car createCar(String regNumber, BigDecimal rentalRate, String brand, boolean isElectric) throws IOException {
        return carDao.createCar(new Car(regNumber, rentalRate, brand, isElectric));
    }

    public Car updateCarInformation() {
        // TODO
        return null;
    }
}
