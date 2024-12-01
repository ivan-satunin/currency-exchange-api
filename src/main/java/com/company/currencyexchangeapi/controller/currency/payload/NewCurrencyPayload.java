package com.company.currencyexchangeapi.controller.currency.payload;

public record NewCurrencyPayload(
        String name,
        String code,
        String sign
) {
}
