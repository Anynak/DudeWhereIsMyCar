package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.VehicleTypeMapper;
import com.innowise.DudeWhereIsMyCar.dto.request.VehicleTypeRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleTypeResponse;
import com.innowise.DudeWhereIsMyCar.entity.VehicleType;
import com.innowise.DudeWhereIsMyCar.service.VehicleTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleTypeController {
    private final VehicleTypeMapper vehicleTypeMapper;
    private final VehicleTypeService vehicleTypeService;

    @PostMapping("/setVehicleTypes")
    public ResponseEntity<List<VehicleTypeResponse>> addVehicleTypes(
            @RequestBody @Valid List<VehicleTypeRequest> vehicleTypeRequests) {
        List<VehicleType> vehicleTypes = vehicleTypeService.saveAll(vehicleTypeMapper.toVehicleTypes(vehicleTypeRequests));
        List<VehicleTypeResponse> vehicleTypeResponses = vehicleTypeMapper.toVehicleTypeResponses(vehicleTypes);
        return new ResponseEntity<>(vehicleTypeResponses, HttpStatus.OK);
    }

    @DeleteMapping("deleteVehicleType/{typeId}")
    public ResponseEntity<VehicleTypeResponse> deleteVehicleType(@PathVariable Long typeId) {
        vehicleTypeService.deleteVehicleType(typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getVehicleTypes")
    public ResponseEntity<List<VehicleTypeResponse>> getVehicleTypes() {
        return new ResponseEntity<>(vehicleTypeMapper.toVehicleTypeResponses(vehicleTypeService.getAllVehicleTypes()), HttpStatus.OK);
    }
}
