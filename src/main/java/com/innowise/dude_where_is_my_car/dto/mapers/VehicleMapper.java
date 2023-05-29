package com.innowise.dude_where_is_my_car.dto.mapers;

import com.innowise.dude_where_is_my_car.dto.requests.VehicleRequest;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.VehicleUserRequest;
import com.innowise.dude_where_is_my_car.dto.responses.VehicleResponse;
import com.innowise.dude_where_is_my_car.models.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {
    Vehicle toVehicle(VehicleRequest request);

    @Mapping(target = "vehicleId", ignore = true)
    Vehicle toVehicle(VehicleUserRequest request);

    VehicleResponse toVehicleResponse(Vehicle vehicle);
}
