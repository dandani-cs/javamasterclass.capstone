package com.capstone.service;

import com.capstone.dao.UserDao;
import com.capstone.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    UserDao userDao = mock(UserDao.class);

    @Test
    public void shouldGetUserFromUUID() {
        UUID expectedId = UUID.randomUUID();
        User expectedUser = new User(expectedId, "foo bar");
        when(userDao.getUser(expectedId)).thenReturn(expectedUser);

        UserService userService = new UserService(userDao);
        User result = userService.getUser(expectedId);

        Assertions.assertEquals(expectedId, result.getId());
        Assertions.assertEquals("foo bar", result.getName());
    }

    @Test
    public void shouldGetUserFromStringUUID() {
        UUID uuid = UUID.randomUUID();
        String expectedId = uuid.toString();
        User expectedUser = new User(uuid, "foo bar");
        when(userDao.getUser(uuid)).thenReturn(expectedUser);

        UserService userService = new UserService(userDao);
        User result = userService.getUser(expectedId);

        Assertions.assertEquals(expectedId, result.getId().toString());
        Assertions.assertEquals("foo bar", result.getName());
    }

    @Test
    public void shouldGetUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "foo bar"));
        users.add(new User(UUID.randomUUID(), "bar foo"));
        when(userDao.getUsers()).thenReturn(users);

        UserService userService = new UserService(userDao);
        List<User> result = userService.getUsers();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("foo bar", result.get(0).getName());
        Assertions.assertEquals("bar foo", result.get(1).getName());
    }

}
