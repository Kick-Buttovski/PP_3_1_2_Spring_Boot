package com.example.PP_3_1_2_Spring_Boot.dao;


import com.example.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;

public interface UserDao {
    User getUser(long id);

    List<User> listUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
