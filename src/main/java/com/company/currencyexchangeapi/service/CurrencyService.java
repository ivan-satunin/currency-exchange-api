package com.company.currencyexchangeapi.service;

import com.company.currencyexchangeapi.entity.Currency;

public interface CurrencyService {

    Iterable<Currency> findAllCurrencies();

    Currency findByCode(String code);

    Currency createCurrency(String fullName,
                            String code,
                            String sign);
}
