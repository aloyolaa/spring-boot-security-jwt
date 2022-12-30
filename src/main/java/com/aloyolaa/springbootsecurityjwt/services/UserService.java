package com.aloyolaa.springbootsecurityjwt.services;

import com.aloyolaa.springbootsecurityjwt.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

}
