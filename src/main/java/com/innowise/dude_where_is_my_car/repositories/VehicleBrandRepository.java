package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {
}
