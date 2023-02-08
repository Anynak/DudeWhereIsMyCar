package com.innowise.DudeWhereIsMyCar.vehicleBrand;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle_brand", schema = "dude_where_is_my_car")
public class VehicleBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_brand_id", nullable = false)
    private Long vehicleBrandId;

    @Column(name = "vehicle_brand_name", nullable = false, unique = true)
    private String vehicleBrandName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VehicleBrand that = (VehicleBrand) o;
        return vehicleBrandId != null && Objects.equals(vehicleBrandId, that.vehicleBrandId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
