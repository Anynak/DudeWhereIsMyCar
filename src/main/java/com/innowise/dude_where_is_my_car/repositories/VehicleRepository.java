package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
