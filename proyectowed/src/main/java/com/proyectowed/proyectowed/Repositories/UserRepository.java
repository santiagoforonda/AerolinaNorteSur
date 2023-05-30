package com.proyectowed.proyectowed.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectowed.proyectowed.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFullName(String fullName);
    Boolean existsByFullName(String fullName);
    Boolean existsByEmail(String email);


}
