package com.company.currencyexchangeapi.exception;

public class CreateUpdateExchangeRateException extends RuntimeException {

    public CreateUpdateExchangeRateException(String message) {
        super(message);
    }

    public CreateUpdateExchangeRateException(String message, Throwable cause) {
        super(message, cause);
    }
}
