package com.proyectowed.proyectowed.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.proyectowed.proyectowed.Entities.User;

public interface UserService {

    User getById(Long id);

    List<User> findAll();

    Optional<User> finById(Long id);

    User create(User user);

    Optional<User> update(Long id,User oldUser);

    ResponseEntity<?> Delete(Long id);

}
