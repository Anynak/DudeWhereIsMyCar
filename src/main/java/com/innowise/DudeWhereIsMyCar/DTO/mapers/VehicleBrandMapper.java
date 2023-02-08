package com.innowise.DudeWhereIsMyCar.DTO.mapers;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleBrandRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleBrandResponse;
import com.innowise.DudeWhereIsMyCar.model.VehicleBrand;
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
