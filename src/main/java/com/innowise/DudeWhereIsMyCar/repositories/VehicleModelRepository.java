package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.models.VehicleBrand;
import com.innowise.DudeWhereIsMyCar.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
    List<VehicleModel> findAllByVehicleBrand(VehicleBrand vehicleBrand);
}
