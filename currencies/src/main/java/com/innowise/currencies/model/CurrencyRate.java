package com.innowise.currencies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "currency_rate", schema = "currencies")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id", nullable = false)
    private Long rateId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_currency_id")
    private Currency currency;

    @Column(name = "rate", nullable = false)
    private Float rate;
    @Column(name = "date", nullable = false)
    private LocalDate date;
}
