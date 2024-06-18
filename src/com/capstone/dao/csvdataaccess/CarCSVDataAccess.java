package com.capstone.dao.csvdataaccess;

import com.capstone.dao.CarDao;
import com.capstone.helper.CSVHelper;
import com.capstone.model.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CarCSVDataAccess implements CarDao {
    private static final String CSV_FILE = "src/resources/cars.csv";
    @Override
    public List<Car> getCars() {
        return CSVHelper.getData(CSV_FILE).stream()
                .map(this::extractCar)
                .collect(Collectors.toList());
    }

    @Override
    public Car getCar(String regNumber) {
        return CSVHelper.getData(CSV_FILE).stream()
                .filter(line -> regNumber.equals(line.split(",")[0]))
                .findFirst()
                .map(this::extractCar)
                .orElse(null);
    }

    @Override
    public Car createCar(Car newCar) {
        CSVHelper.writeData(CSV_FILE, newCar.toCSVdata());
        return newCar;
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
