package com.capstone.helper.faker;

import com.capstone.model.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserFaker implements DataFaker<User> {
    @Override
    public List<User> generateData() {
        List<User> newData = new ArrayList<>();
        Faker faker = new Faker();
        while (newData.size() < 20) {
            newData.add(new User(UUID.randomUUID(), faker.name().name()));
        }
        return newData;
    }

    @Override
    public String getData() {
        return generateData().stream().map(User::toCSVData).collect(Collectors.joining());
    }
}
