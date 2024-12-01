package com.company.currencyexchangeapi.dto;

import com.company.currencyexchangeapi.entity.Currency;

public record ExchangeConvertDto(
        Currency baseCurrency,
        Currency targetCurrency,
        double rate,
        double amount,
        double convertedAmount
) {
}
