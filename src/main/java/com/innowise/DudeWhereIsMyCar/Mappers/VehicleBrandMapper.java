package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.request.VehicleBrandRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleBrandResponse;
import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleBrandMapper {
    VehicleBrand toVehicleBrand(VehicleBrandRequest vehicleBrandRequest);

    VehicleBrandResponse toVehicleBrandResponse(VehicleBrand vehicleBrand);
}
