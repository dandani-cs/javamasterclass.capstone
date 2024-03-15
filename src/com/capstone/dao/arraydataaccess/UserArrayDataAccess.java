package com.capstone.dao.arraydataaccess;

import com.capstone.dao.UserDao;
import com.capstone.model.User;

import java.util.UUID;

public class UserArrayDataAccess implements UserDao {
    private static final User[] users;

    static {
        users = new User[]{
                new User(UUID.fromString("a6a0b0dd-08cb-41b8-9108-682180bab0b9"), "Anita"),
                new User(UUID.fromString("d33fe925-515c-4c43-a966-cb74c3b02e3e"), "Benjamin"),
        };
    }


    @Override
    public User[] getUsers() {
        return users;
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
    public User addUser(UUID uuid, String name) {
        // TODO
        return null;
    }
}
