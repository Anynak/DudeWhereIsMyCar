package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.request.VehicleTypeRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleTypeResponse;
import com.innowise.DudeWhereIsMyCar.entity.VehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleTypeMapper {
    List<VehicleType> toVehicleTypes(List<VehicleTypeRequest> vehicleTypesRequest);

    List<VehicleTypeResponse> toVehicleTypeResponses(List<VehicleType> vehicleTypes);


}
