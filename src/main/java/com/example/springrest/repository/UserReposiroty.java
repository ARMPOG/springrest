package com.example.springrest.repository;

import com.example.springrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiroty extends JpaRepository<User, Integer>{

    User getUserById(int id);

    User deleteById(int id);

}
