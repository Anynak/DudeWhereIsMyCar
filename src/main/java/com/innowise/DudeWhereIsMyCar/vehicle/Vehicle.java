package com.innowise.DudeWhereIsMyCar.vehicle;

import com.innowise.DudeWhereIsMyCar.vehicleModel.VehicleModel;
import com.innowise.DudeWhereIsMyCar.vehicleType.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle", schema = "dude_where_is_my_car")
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "color", nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private VehicleType vehicleType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private VehicleModel vehicleModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId != null && Objects.equals(vehicleId, vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
