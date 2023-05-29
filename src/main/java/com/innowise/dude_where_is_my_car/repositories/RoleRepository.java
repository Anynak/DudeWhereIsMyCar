package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}
