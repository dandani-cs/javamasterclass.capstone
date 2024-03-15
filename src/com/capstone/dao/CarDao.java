package com.capstone.dao;

import com.capstone.model.Car;

public interface CarDao {
    Car[] getCars();
    Car getCar(String regNumber);

    Car addCar(Car car);
}
