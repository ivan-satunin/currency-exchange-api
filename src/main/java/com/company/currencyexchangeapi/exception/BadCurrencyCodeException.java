package com.company.currencyexchangeapi.exception;

public class BadCurrencyCodeException extends RuntimeException {

    public BadCurrencyCodeException(String badCode) {
        super("Bad currency code: " + badCode);
    }
}
