package com.company.currencyexchangeapi.repository;

import com.company.currencyexchangeapi.entity.ExchangeRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Integer> {

    @Query("select er from ExchangeRate er where er.baseCurrency.code = :baseCode and er.targetCurrency.code = :targetCode")
    Optional<ExchangeRate> findByBaseAndTargetCode(String baseCode, String targetCode);

    default boolean existsByBaseAndTargetCode(String baseCode, String targetCode) {
        return findByBaseAndTargetCode(baseCode, targetCode).isPresent();
    }
}
