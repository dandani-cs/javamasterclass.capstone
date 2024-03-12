package com.capstone.service;

import com.capstone.dao.UserDao;
import com.capstone.models.User;

import java.util.UUID;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(String uuid) {
        return userDao.getUser(UUID.fromString(uuid));
    }

    public User createUser(String name) {
        return userDao.addUser(UUID.randomUUID(), name);
    }

    public User editUserInfo(String name) {
        // TODO
        return null;
    }
}
