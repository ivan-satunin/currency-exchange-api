package com.company.currencyexchangeapi.controller.exchange.rate.payload;

public record NewExchangeRatePayload(
        String baseCurrencyCode,
        String targetCurrencyCode,
        double rate
) {

}