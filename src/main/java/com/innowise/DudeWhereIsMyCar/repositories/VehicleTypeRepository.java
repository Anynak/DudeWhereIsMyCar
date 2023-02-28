package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
