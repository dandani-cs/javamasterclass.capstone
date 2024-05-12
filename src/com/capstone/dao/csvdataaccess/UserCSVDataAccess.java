package com.capstone.dao.csvdataaccess;

import com.capstone.dao.UserDao;
import com.capstone.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UserCSVDataAccess implements UserDao {
    private static final String CSV_FILE = "src/resources/users.csv";

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Scanner csvScanner = new Scanner(new File(CSV_FILE))) {
            while (csvScanner.hasNextLine()) {
                users.add(extractUser(csvScanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUser(UUID uuid) {
        String id = uuid.toString();
        try (Scanner csvScanner = new Scanner(CSV_FILE)) {
            while (csvScanner.hasNextLine()) {
                String[] data = csvScanner.nextLine().split(",");
                if (id.equals(data[0])) {
                    return new User(uuid, data[1]);
                }
            }
        }
        return null;
    }

    @Override
    public User createUser(User newUser) {
        String data = newUser.getId() + "," + newUser.getName() + "\n";
        try (FileWriter fileWriter = new FileWriter(CSV_FILE, true)) {
            fileWriter.append(data);
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be opened");
        }
        return newUser;
    }

    private User extractUser(String line) {
        String[] data = line.split(",");
        return new User(UUID.fromString(data[0]), data[1]);
    }
}
