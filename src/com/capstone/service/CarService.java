package com.capstone.service;

import com.capstone.dao.CarDao;
import com.capstone.model.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public ArrayList<Car> getCars() {
        return carDao.getCars();
    }

    public Car[] getElectricCars() {
        List<Car> electricCars = new ArrayList<Car>();
        for (Car car : carDao.getCars()) {
            if (car.isElectric()) {
                electricCars.add(car);
            }
        }
        Car[] result = new Car[electricCars.size()];
        return electricCars.toArray(result);
    }

    public Car getCar(String regNumber) {
        return carDao.getCar(regNumber);
    }

    public Car createCar(String regNumber, BigDecimal rentalRate, String brand, boolean isElectric) {
        return carDao.createCar(new Car(regNumber, rentalRate, brand, isElectric));
    }

    public Car updateCarInformation() {
        // TODO
        return null;
    }
}
