package com.capstone.dao;

import com.capstone.model.Car;

import java.util.ArrayList;

public interface CarDao {
    ArrayList<Car> getCars();
    Car getCar(String regNumber);
    Car createCar(Car car);
}
