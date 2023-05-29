package com.innowise.dude_where_is_my_car.dto.mapers;

import com.innowise.dude_where_is_my_car.dto.requests.VehicleBrandRequest;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.VehicleBrandUserRequest;
import com.innowise.dude_where_is_my_car.dto.responses.VehicleBrandResponse;
import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleBrandMapper {
    VehicleBrand toVehicleBrand(VehicleBrandRequest vehicleBrandRequest);

    @Mapping(target = "vehicleBrandName", ignore = true)
    VehicleBrand toVehicleBrand(VehicleBrandUserRequest vehicleBrandUserRequest);

    List<VehicleBrand> toVehicleBrands(Iterable<VehicleBrandRequest> vehicleBrandsRequest);

    List<VehicleBrand> toVehicleBrandsFromVehicleBrandUser(Iterable<VehicleBrandUserRequest> vehicleBrandUserRequest);

    VehicleBrandResponse toVehicleBrandResponse(VehicleBrand vehicleBrand);

    List<VehicleBrandResponse> toVehicleBrandsResponse(List<VehicleBrand> vehicleBrands);


}
