package com.innowise.DudeWhereIsMyCar.vehicleModel;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleModelMapper {


    List<VehicleModel> toVehicleModels(List<VehicleModelRequest> vehicleBrandsRequest);

    List<VehicleModelResponse> toVehicleModelResponses(List<VehicleModel> vehicleModels);




}
