package com.capstone.service;

import com.capstone.dao.UserDao;
import com.capstone.helper.UserHelper;
import com.capstone.model.User;

import java.util.UUID;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(String userid) {
        UUID uuid = UserHelper.extractUserID(userid);
        if (uuid == null) {
            return null;
        }
        return getUser(uuid);
    }

    public User getUser(UUID uuid) {
        return userDao.getUser(uuid);
    }

    public User createUser(String name) {
        return userDao.addUser(UUID.randomUUID(), name);
    }

    public User editUserInfo(String name) {
        // TODO: not very applicable on arrays
        return null;
    }
}
