package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.VehicleBrandMapper;
import com.innowise.DudeWhereIsMyCar.dto.request.VehicleBrandRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleBrandResponse;
import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;
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
@RequestMapping("/api")
public class VehicleBrandController {

    private final VehicleBrandService vehicleBrandService;
    private final VehicleBrandMapper vehicleBrandMapper;

    @PostMapping("/vehicleBrands")
    public ResponseEntity<List<VehicleBrandResponse>> addVehicleBrands(@RequestBody @Valid ValidList<VehicleBrandRequest> vehicleBrandsRequest) {
        List<VehicleBrand> savedVehicleBrands = vehicleBrandService.addAllVehicleBrands(vehicleBrandMapper.toVehicleBrands(vehicleBrandsRequest));
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandsResponse(savedVehicleBrands),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/vehicleBrand/{brandId}")
    public ResponseEntity<?> removeVehicleBrand(@PathVariable Long brandId) {
        vehicleBrandService.removeVehicleBrandById(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vehicleBrands")
    public ResponseEntity<List<VehicleBrandResponse>> getVehicleBrands() {
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandsResponse(vehicleBrandService.getAllVehicleBrands()),
                HttpStatus.OK
        );
    }
}
