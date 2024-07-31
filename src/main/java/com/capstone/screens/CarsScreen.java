package com.capstone.screens;

import com.capstone.service.CarService;
import com.capstone.model.Car;

import java.util.Scanner;

public class CarsScreen implements IScreen {

    private final CarService carService;

    public CarsScreen(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void display(Scanner scanner) {
        for (Car car : carService.getCars()) {
            System.out.println(car);
        }
    }
}
