package com.innowise.dude_where_is_my_car.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class VehicleBrandRequest {

    private Long vehicleBrandId;

    @NotBlank(message = "vehicleBrandName не должно быть пустым")
    @NotNull
    @Length(max = 16)
    private String vehicleBrandName;

}
