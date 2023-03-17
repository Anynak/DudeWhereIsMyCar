package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleModelResponse;
import com.innowise.DudeWhereIsMyCar.models.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleModelMapper {


    List<VehicleModel> toVehicleModels(List<VehicleModelRequest> vehicleBrandsRequest);
    @Mapping(target = "vehicleModelName", ignore = true)
    VehicleModel toVehicleModel(VehicleModelRequest vehicleBrandsRequest);
    List<VehicleModelResponse> toVehicleModelResponses(List<VehicleModel> vehicleModels);


}
