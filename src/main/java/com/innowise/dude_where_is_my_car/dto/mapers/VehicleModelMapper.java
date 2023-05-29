package com.innowise.dude_where_is_my_car.dto.mapers;

import com.innowise.dude_where_is_my_car.dto.requests.VehicleModelRequest;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.VehicleModelUserRequest;
import com.innowise.dude_where_is_my_car.dto.responses.VehicleModelResponse;
import com.innowise.dude_where_is_my_car.models.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleModelMapper {


    List<VehicleModel> toVehicleModels(List<VehicleModelRequest> vehicleBrandsRequest);

    VehicleModel toVehicleModel(VehicleModelRequest vehicleBrandsRequest);

    @Mapping(target = "vehicleModelName", ignore = true)
    VehicleModel toVehicleModel(VehicleModelUserRequest vehicleBrandsRequest);

    List<VehicleModelResponse> toVehicleModelResponses(List<VehicleModel> vehicleModels);


}
