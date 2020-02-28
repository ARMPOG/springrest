package com.example.springrest.rest;


import com.example.springrest.model.User;
import com.example.springrest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity getUserById(@PathVariable(name = "id") int id) {
        User userById = userService.getUserById(id);
        if (userById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with id " + id + " is not found");
        }
        return ResponseEntity.ok(userById);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUserById(@PathVariable(name = "id") int id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping()
    public ResponseEntity saveUser (@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("saved");
    }
}
