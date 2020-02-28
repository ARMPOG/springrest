package com.example.springrest.service.impl;


import com.example.springrest.model.User;
import com.example.springrest.repository.UserReposiroty;
import com.example.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserReposiroty userReposiroty;

    @Autowired
    public UserServiceImpl(UserReposiroty userReposiroty) {
        this.userReposiroty = userReposiroty;
    }


    @Override
    public List<User> getAllUsers() {
        return userReposiroty.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userReposiroty.getUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userReposiroty.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        userReposiroty.save(user);
    }
}
