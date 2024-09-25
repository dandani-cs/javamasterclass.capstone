package com.capstone.helper.faker;

import com.capstone.dao.csvdataaccess.CarCSVDataAccess;
import com.capstone.dao.csvdataaccess.UserCSVDataAccess;
import com.capstone.entities.BookingEntity;
import com.capstone.helper.CSVHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingFaker implements DataFaker<BookingEntity> {
    private static final String CAR_FILENAME = "cars.csv";
    private static final String USER_FILENAME = "users.csv";

    private final Random random = new Random();

    @Override
    public List<BookingEntity> generateData() {
        List<BookingEntity> newData = new ArrayList<>();
        List<String> users = CSVHelper.getData(USER_FILENAME, UserCSVDataAccess.USER_FAKER);
        List<String> cars = CSVHelper.getData(CAR_FILENAME, CarCSVDataAccess.CAR_FAKER);

        while (newData.size() < 20) {
            newData.add(new BookingEntity(UUID.randomUUID().toString(), getRandomData(users, users.size()), getRandomData(cars, cars.size()), "1"));
        }

        return newData;
    }

    @Override
    public String getData() {
        return generateData().stream().map(BookingEntity::toCSVData).collect(Collectors.joining(""));
    }

    private String getRandomData(List<String> data, int size) {
        return data.get(random.nextInt(size)).split(",")[0];
    }
}
