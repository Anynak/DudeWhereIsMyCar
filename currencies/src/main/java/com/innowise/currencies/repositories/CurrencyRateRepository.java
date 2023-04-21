package com.innowise.currencies.repositories;

import com.innowise.currencies.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

    @Query("SELECT cr FROM CurrencyRate cr JOIN FETCH cr.currency c WHERE cr.date = :date")
    Optional<List<CurrencyRate>> findAllByDateWithCurrency(@Param("date") LocalDate date);

    @Query("SELECT MAX(cr.date) FROM CurrencyRate cr")
    LocalDate findLatestDate();

}

