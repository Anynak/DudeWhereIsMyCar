package com.innowise.DudeWhereIsMyCar.DTO.mapers;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleTypeRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleTypeResponse;
import com.innowise.DudeWhereIsMyCar.model.VehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleTypeMapper {
    List<VehicleType> toVehicleTypes(List<VehicleTypeRequest> vehicleTypesRequest);

    List<VehicleTypeResponse> toVehicleTypeResponses(List<VehicleType> vehicleTypes);


}
