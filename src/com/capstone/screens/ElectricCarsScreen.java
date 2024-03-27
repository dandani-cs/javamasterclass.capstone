package com.capstone.screens;

import com.capstone.model.Car;
import com.capstone.service.CarService;

import java.util.Scanner;

public class ElectricCarsScreen implements IScreen {

    private final CarService carService;

    public ElectricCarsScreen(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void display(Scanner scanner) {
        for (Car car : carService.getElectricCars()) {
            System.out.println(car);
        }
    }
}
