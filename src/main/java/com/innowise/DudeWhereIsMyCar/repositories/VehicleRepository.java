package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
