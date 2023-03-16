package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.userRequests.VehicleUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleResponse;
import com.innowise.DudeWhereIsMyCar.models.Vehicle;
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
