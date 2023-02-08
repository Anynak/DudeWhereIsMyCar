package com.innowise.DudeWhereIsMyCar.vehicleType;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleTypeMapper {
    List<VehicleType> toVehicleTypes(List<VehicleTypeRequest> vehicleTypesRequest);

    List<VehicleTypeResponse> toVehicleTypeResponses(List<VehicleType> vehicleTypes);


}
