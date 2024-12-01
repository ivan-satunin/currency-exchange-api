package com.company.currencyexchangeapi.service;

import com.company.currencyexchangeapi.entity.ExchangeRate;

public interface ExchangeRateService {

    Iterable<ExchangeRate> findAll();

    default ExchangeRate findByBaseAndTargetCode(String baseAndTargetCode) {
        var baseCode = baseAndTargetCode.substring(0, 3);
        var targetCode = baseAndTargetCode.substring(3, 6);
        return findByBaseAndTargetCode(baseCode, targetCode);
    }
    ExchangeRate findByBaseAndTargetCode(String baseCode, String targetCode);

    ExchangeRate create(
            String baseCurrencyCode,
            String targetCurrencyCode,
            double rate
    );

    ExchangeRate update(String baseAndTargetCode, double rate);

    boolean existsByBaseAndTargetCode(String baseCode, String targetCode);
}
