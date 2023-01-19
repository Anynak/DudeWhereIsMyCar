package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.request.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleModelResponse;
import com.innowise.DudeWhereIsMyCar.entity.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleModelMapper {


    List<VehicleModel> toVehicleModels(List<VehicleModelRequest> vehicleBrandsRequest);

    List<VehicleModelResponse> toVehicleModelResponses(List<VehicleModel> vehicleModels);




}
