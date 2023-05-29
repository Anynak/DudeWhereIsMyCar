package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);

    Boolean existsByLogin(String login);

    Boolean existsByEmail(String email);

    Boolean existsByPhone(String phone);

}
