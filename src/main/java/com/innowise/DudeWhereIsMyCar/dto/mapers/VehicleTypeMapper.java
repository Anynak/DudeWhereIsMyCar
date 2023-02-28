package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleTypeRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleTypeResponse;
import com.innowise.DudeWhereIsMyCar.models.VehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleTypeMapper {
    List<VehicleType> toVehicleTypes(List<VehicleTypeRequest> vehicleTypesRequest);

    List<VehicleTypeResponse> toVehicleTypeResponses(List<VehicleType> vehicleTypes);


}
