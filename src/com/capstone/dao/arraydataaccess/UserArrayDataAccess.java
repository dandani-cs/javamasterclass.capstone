package com.capstone.dao.arraydataaccess;

import com.capstone.dao.UserDao;
import com.capstone.model.User;

import java.util.Arrays;
import java.util.UUID;

public class UserArrayDataAccess implements UserDao {
    private static final User[] users = new User[100];
    private static int size = 2;

    public UserArrayDataAccess() {
        if (users[0] == null) {
            users[0] = new User(UUID.fromString("a6a0b0dd-08cb-41b8-9108-682180bab0b9"), "Anita");
            users[1] = new User(UUID.fromString("d33fe925-515c-4c43-a966-cb74c3b02e3e"), "Benjamin");
        }
    }

    private static int getSize() {
        return size;
    }

    private static void setSize(int size) {
        UserArrayDataAccess.size = size;
    }

    @Override
    public User[] getUsers() {
        return Arrays.copyOfRange(users, 0, size);
    }

    public User getUser(UUID uuid) {
        for (User user : users) {
            if (user.getId().equals(uuid)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User createUser(User newUser) {
        // TODO: unit test to return the correct user
        int initSize = getSize();
        users[initSize] = newUser;
        setSize(initSize + 1);
        return users[initSize];
    }
}
