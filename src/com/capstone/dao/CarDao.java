package com.capstone.dao;

import com.capstone.models.Car;

public interface CarDao {
    Car[] getCars();
    Car getCar(String regNumber);

    Car addCar(Car car);
}
