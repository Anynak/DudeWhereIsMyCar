package com.innowise.DudeWhereIsMyCar.vehicleModel;

import com.innowise.DudeWhereIsMyCar.validators.ValidList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleModelController {

    private final VehicleModelMapper vehicleModelMapper;
    private final VehicleModelService vehicleModelService;

    @PostMapping("/vehicleModels")
    public ResponseEntity<List<VehicleModelResponse>> addVehicleModels(@RequestBody @Valid ValidList<VehicleModelRequest> vehicleModelsRequest) {
        List<VehicleModel> vm = vehicleModelMapper.toVehicleModels(vehicleModelsRequest);
        List<VehicleModel> savedVehicleModels = vehicleModelService.addVehicleModels(vm);
        return new ResponseEntity<>(
                vehicleModelMapper.toVehicleModelResponses(savedVehicleModels),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/vehicleModel/{modelId}")
    public ResponseEntity<?> removeVehicleModel(@PathVariable Long modelId) {
        vehicleModelService.removeVehicleModelById(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vehicleModels")
    public ResponseEntity<List<VehicleModelResponse>> getVehicleModels() {
        return new ResponseEntity<>(vehicleModelMapper.toVehicleModelResponses(vehicleModelService.getAllVehicleModels()), HttpStatus.OK);
    }


}
