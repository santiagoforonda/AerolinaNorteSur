package com.proyectowed.proyectowed.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectowed.proyectowed.Entities.ERole;
import com.proyectowed.proyectowed.Entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    
    Optional<Role> findByName(ERole name);
}
