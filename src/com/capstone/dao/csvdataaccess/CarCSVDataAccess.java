package com.capstone.dao.csvdataaccess;

import com.capstone.dao.CarDao;
import com.capstone.model.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class CarCSVDataAccess implements CarDao {
    private static final String CSV_FILE = "src/resources/cars.csv";
    @Override
    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        try (Scanner csvScanner = new Scanner(new File(CSV_FILE))) {
            while (csvScanner.hasNextLine()) {
                cars.add(extractCar(csvScanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public Car getCar(String regNumber) {
        try (Scanner csvScanner = new Scanner(CSV_FILE)) {
            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                String[] data = line.split(",");
                if (regNumber.equals(data[0])) {
                    return extractCar(line);
                }
            }
        }
        return null;
    }

    @Override
    public Car createCar(Car car) {
        return null;
    }

    private Car extractCar(String line) {
        String[] data = line.split(",");
        return new Car(
                data[0],
                new BigDecimal(data[1]),
                data[2],
                Boolean.parseBoolean(data[3])
        );
    }
}