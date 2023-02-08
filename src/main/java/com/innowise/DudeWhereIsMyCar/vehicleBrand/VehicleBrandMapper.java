package com.innowise.DudeWhereIsMyCar.vehicleBrand;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleBrandMapper {
    VehicleBrand toVehicleBrand(VehicleBrandRequest vehicleBrandRequest);

    List<VehicleBrand> toVehicleBrands(Iterable<VehicleBrandRequest> vehicleBrandsRequest);

    VehicleBrandResponse toVehicleBrandResponse(VehicleBrand vehicleBrand);

    List<VehicleBrandResponse> toVehicleBrandsResponse(List<VehicleBrand> vehicleBrands);


}
