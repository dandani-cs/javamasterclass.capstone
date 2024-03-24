package com.capstone.dao;

import com.capstone.model.User;

import java.util.UUID;

public interface UserDao {
    User[] getUsers();
    User getUser(UUID uuid);
    User createUser(User newUser);
}
