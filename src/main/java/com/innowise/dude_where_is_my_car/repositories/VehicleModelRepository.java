package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import com.innowise.dude_where_is_my_car.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
    List<VehicleModel> findAllByVehicleBrand(VehicleBrand vehicleBrand);

}
