package com.company.currencyexchangeapi.service;

import com.company.currencyexchangeapi.dto.ExchangeConvertDto;

public interface ExchangeConvertService {

    ExchangeConvertDto convertCurrency(String baseCode, String targetCode, double amount);
}
