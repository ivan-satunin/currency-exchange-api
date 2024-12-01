package com.company.currencyexchangeapi.repository;

import com.company.currencyexchangeapi.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    Optional<Currency> findCurrencyByCode(String code);
}
