package com.company.currencyexchangeapi.exception;

public class NotFoundExchangeRateException extends RuntimeException {

    public NotFoundExchangeRateException(String message) {
        super(message);
    }


    public NotFoundExchangeRateException(String baseCode, String targetCode) {
        this("There isn't exchange rate by base and target code: " + baseCode + ", " + targetCode);
    }
}
