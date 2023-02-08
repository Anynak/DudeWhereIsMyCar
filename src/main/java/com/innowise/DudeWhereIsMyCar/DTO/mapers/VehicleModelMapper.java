package com.innowise.DudeWhereIsMyCar.DTO.mapers;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleModelResponse;
import com.innowise.DudeWhereIsMyCar.model.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleModelMapper {


    List<VehicleModel> toVehicleModels(List<VehicleModelRequest> vehicleBrandsRequest);

    List<VehicleModelResponse> toVehicleModelResponses(List<VehicleModel> vehicleModels);




}
