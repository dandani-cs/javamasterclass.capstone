package com.capstone.screens;

import com.capstone.model.User;
import com.capstone.service.UserService;

import java.util.Scanner;

public class UsersScreen implements IScreen {
    private final UserService userService;

    public UsersScreen(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void display(Scanner scanner) {
        for (User user : userService.getUsers()) {
            System.out.println(user);
        }
    }
}
