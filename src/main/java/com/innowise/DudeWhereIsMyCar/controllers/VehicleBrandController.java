package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.DTO.mapers.VehicleBrandMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleBrandRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleBrandResponse;
import com.innowise.DudeWhereIsMyCar.model.VehicleBrand;
import com.innowise.DudeWhereIsMyCar.service.VehicleBrandService;
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
@RequestMapping("/vehicleBrands")
public class VehicleBrandController {

    private final VehicleBrandService vehicleBrandService;
    private final VehicleBrandMapper vehicleBrandMapper;

    @PostMapping("/v1")
    public ResponseEntity<List<VehicleBrandResponse>> addVehicleBrands(@RequestBody @Valid ValidList<VehicleBrandRequest> vehicleBrandsRequest) {
        List<VehicleBrand> savedVehicleBrands = vehicleBrandService.addAllVehicleBrands(vehicleBrandMapper.toVehicleBrands(vehicleBrandsRequest));
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandsResponse(savedVehicleBrands),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/v1/{brandId}")
    public ResponseEntity<?> removeVehicleBrand(@PathVariable Long brandId) {
        vehicleBrandService.removeVehicleBrandById(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1")
    public List<VehicleBrandResponse> getVehicleBrands() {
        return vehicleBrandMapper.toVehicleBrandsResponse(vehicleBrandService.getAllVehicleBrands());
    }
}
