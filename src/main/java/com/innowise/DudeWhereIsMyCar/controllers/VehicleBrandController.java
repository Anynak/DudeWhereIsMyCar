package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.controllers.validators.ValidList;
import com.innowise.DudeWhereIsMyCar.dto.mapers.VehicleBrandMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleBrandRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleBrandResponse;
import com.innowise.DudeWhereIsMyCar.models.VehicleBrand;
import com.innowise.DudeWhereIsMyCar.service.VehicleBrandService;
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
