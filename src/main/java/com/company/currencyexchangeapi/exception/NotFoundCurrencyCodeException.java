package com.company.currencyexchangeapi.exception;

public class NotFoundCurrencyCodeException extends RuntimeException {

    public NotFoundCurrencyCodeException(String code) {
        super("Missing currency by code: " + code);
    }
}
