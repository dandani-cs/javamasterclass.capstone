package com.capstone.dao.arraydataaccess;

import com.capstone.dao.CarDao;
import com.capstone.models.Car;

import java.math.BigDecimal;

public class CarArrayDataAccess implements CarDao {
    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("ABC1234", new BigDecimal(89.00), "Tesla", true),
                new Car("ZYX0987", new BigDecimal(56.50), "Mercedes Benz", false),
                new Car("QWE4534", new BigDecimal(46.10), "Toyota", false)
        };
    }

    @Override
    public Car[] getCars() {
        return cars;
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
    public Car addCar(Car car) {
        // TODO
        return null;
    }
}
