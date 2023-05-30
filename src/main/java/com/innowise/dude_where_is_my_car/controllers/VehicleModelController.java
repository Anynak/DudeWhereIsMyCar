package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.controllers.validators.ValidList;
import com.innowise.dude_where_is_my_car.dto.mapers.VehicleModelMapper;
import com.innowise.dude_where_is_my_car.dto.requests.VehicleModelRequest;
import com.innowise.dude_where_is_my_car.dto.responses.VehicleModelResponse;
import com.innowise.dude_where_is_my_car.models.VehicleModel;
import com.innowise.dude_where_is_my_car.service.VehicleModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/vehicleModels")
public class VehicleModelController {

    private final VehicleModelMapper vehicleModelMapper;
    private final VehicleModelService vehicleModelService;

    @PostMapping("/v1")
    public List<VehicleModelResponse> addVehicleModels(@RequestBody @Valid ValidList<VehicleModelRequest> vehicleModelsRequest) {
        List<VehicleModel> vm = vehicleModelMapper.toVehicleModels(vehicleModelsRequest);
        List<VehicleModel> savedVehicleModels = vehicleModelService.addVehicleModels(vm);
        return vehicleModelMapper.toVehicleModelResponses(savedVehicleModels);
    }

    @DeleteMapping("/v1/{modelId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeVehicleModel(@PathVariable Long modelId) {
        vehicleModelService.removeVehicleModelById(modelId);
    }

    @GetMapping("/v1/all")
    public List<VehicleModelResponse> getVehicleModels() {
        return vehicleModelMapper.toVehicleModelResponses(vehicleModelService.getAllVehicleModels());
    }

    @GetMapping("/v1")
    public List<VehicleModelResponse> getVehicleModelsByBrand(@RequestParam(name = "brandId") Long brandId) {
        return vehicleModelMapper.toVehicleModelResponses(vehicleModelService.getVehicleModelsByBrand(brandId));
    }


}
