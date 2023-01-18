package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.CarBrand;
import com.innowise.DudeWhereIsMyCar.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarBrandServiceImpl implements CarBrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<CarBrand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public CarBrand addBrand(CarBrand carBrand) {
        return brandRepository.save(carBrand);
    }

    @Override
    public void removeBrand(CarBrand carBrand) {
        brandRepository.delete(carBrand);
    }
}
