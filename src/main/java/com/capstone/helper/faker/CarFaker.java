package com.capstone.helper.faker;

import com.capstone.entities.BookingEntity;
import com.capstone.model.Car;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarFaker implements DataFaker<Car> {

    @Override
    public List<Car> generateData() {
        List<Car> newData = new ArrayList<>();
        Faker faker = new Faker();
        while (newData.size() < 20) {
            newData.add(new Car(faker.vehicle().licensePlate(), BigDecimal.TEN, faker.vehicle().model(), isElectricRandom()));
        }
        return newData;
    }

    @Override
    public String getData() {
        return generateData().stream().map(Car::toCSVdata).collect(Collectors.joining(""));
    }

    private boolean isElectricRandom() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
