package com.innowise.currencies.repositories;

import com.innowise.currencies.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findByCurrencyName(String currencyName);
}
