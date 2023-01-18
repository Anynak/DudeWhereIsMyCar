package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.CarBrandRequest;
import com.innowise.DudeWhereIsMyCar.dto.CarBrandResponse;
import com.innowise.DudeWhereIsMyCar.entity.CarBrand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarBrandMapper {
    CarBrand toCarBrand(CarBrandRequest carBrandRequest);

    CarBrandResponse toCarBrandResponse(CarBrand carBrand);
}
