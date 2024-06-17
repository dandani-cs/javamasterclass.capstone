package com.capstone.screens;

import com.capstone.service.CarService;

import java.util.Scanner;

public class ElectricCarsScreen implements IScreen {

    private final CarService carService;

    public ElectricCarsScreen(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void display(Scanner scanner) {
        carService.getElectricCars().forEach(System.out::println);
    }
}
