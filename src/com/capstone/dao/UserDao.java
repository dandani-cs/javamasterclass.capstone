package com.capstone.dao;

import com.capstone.models.User;

import java.util.UUID;

public interface UserDao {
    User[] getUsers();

    User getUser(UUID uuid);

    User addUser(UUID uuid, String name);
}
