package com.capstone.dao;

import com.capstone.model.Car;

import java.io.IOException;
import java.util.List;

public interface CarDao {
    List<Car> getCars();
    Car getCar(String regNumber);
    Car createCar(Car car) throws IOException;
}
