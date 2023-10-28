package com.example.PP_3_1_2_Spring_Boot.service;


import com.example.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;

public interface UserService {
    User getUser(long id);

    List<User> listUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
