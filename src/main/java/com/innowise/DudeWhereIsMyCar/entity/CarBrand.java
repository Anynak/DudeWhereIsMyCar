package com.innowise.DudeWhereIsMyCar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "car_brand", schema = "dude_where_is_my_car")
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_brand_id", nullable = false)
    private Long brandId;

    @Column(name = "car_brand_name", nullable = false)
    private String brandName;

}
