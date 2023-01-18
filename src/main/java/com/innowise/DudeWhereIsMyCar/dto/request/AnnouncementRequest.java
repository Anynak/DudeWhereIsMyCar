package com.innowise.DudeWhereIsMyCar.dto.request;

import com.innowise.DudeWhereIsMyCar.entity.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnnouncementRequest {

    @NotNull
    @NotBlank
    private Vehicle vehicle;

    @NotNull
    @NotBlank
    private Float price;

    @NotNull
    @NotBlank
    private String comment;
}
