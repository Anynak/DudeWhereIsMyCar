package com.innowise.currencies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "currency", schema = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id", nullable = false)
    private Integer currencyId;
    @Column(name = "currency_name", unique = true, nullable = false, length = 3)
    private String currencyName;

    public Currency(String currencyName) {
        this.currencyName = currencyName;
    }

}
