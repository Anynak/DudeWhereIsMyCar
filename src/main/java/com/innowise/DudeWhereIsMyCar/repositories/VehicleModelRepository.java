package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}
