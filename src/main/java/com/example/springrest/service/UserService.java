package com.example.springrest.service;

import com.example.springrest.model.User;


import java.util.List;


public interface UserService {

   List<User> getAllUsers();

   User getUserById(int id);

   void deleteUserById(int id);

   void saveUser(User user);

}
