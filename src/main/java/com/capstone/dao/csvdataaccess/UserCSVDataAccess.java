package com.capstone.dao.csvdataaccess;

import com.capstone.dao.UserDao;
import com.capstone.helper.CSVHelper;
import com.capstone.helper.faker.DataFaker;
import com.capstone.helper.faker.UserFaker;
import com.capstone.model.User;

import java.util.ArrayList;
import java.util.UUID;

import static com.capstone.helper.CSVHelper.RESOURCES_DIR;

public class UserCSVDataAccess implements UserDao {
    private static final String CSV_FILE = "users.csv";
    public static final DataFaker USER_FAKER = new UserFaker();

    @Override
    public ArrayList<User> getUsers() {
        return new ArrayList<>(CSVHelper.getData(CSV_FILE, USER_FAKER).stream().map(this::extractUser).toList());
    }

    @Override
    public User getUser(UUID uuid) {
        return CSVHelper.getData(CSV_FILE, USER_FAKER).stream()
                .map(line -> line.split(","))
                .filter(strData -> uuid.toString().equals(strData[0]))
                .findFirst()
                .map(strings -> new User(uuid, strings[1]))
                .orElse(null);
    }

    @Override
    public User createUser(User newUser) {
        CSVHelper.writeData(CSV_FILE, newUser.getId() + "," + newUser.getName() + "\n");
        return newUser;
    }

    private User extractUser(String line) {
        String[] data = line.split(",");
        return new User(UUID.fromString(data[0]), data[1]);
    }
}
