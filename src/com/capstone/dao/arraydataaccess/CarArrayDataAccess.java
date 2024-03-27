package com.capstone.dao.arraydataaccess;

import com.capstone.dao.CarDao;
import com.capstone.model.Car;

import java.math.BigDecimal;
import java.util.Arrays;

public class CarArrayDataAccess implements CarDao {
    private static final Car[] cars = new Car[100];
    private static int size = 3;

    public CarArrayDataAccess() {
        if (cars[0] == null) {
            cars[0] = new Car("ABC1234", new BigDecimal("89.00"), "Tesla", true);
            cars[1] = new Car("ZYX0987", new BigDecimal("56.50"), "Mercedes Benz", false);
            cars[2] = new Car("QWE4534", new BigDecimal("46.10"), "Toyota", false);
        }
    }

    private static int getSize() {
        return size;
    }

    private static void setSize(int size) {
        CarArrayDataAccess.size = size;
    }

    @Override
    public Car[] getCars() {
        return Arrays.copyOfRange(cars, 0, size);
    }

    public Car getCar(String regNumber) {
        for (Car car : cars) {
            if (car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car createCar(Car newCar) {
        // TODO: unit test to return the correct car
        int initSize = getSize();
        cars[initSize] = newCar;
        setSize(initSize + 1);
        return cars[initSize];
    }
}
