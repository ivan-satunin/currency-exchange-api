package com.company.currencyexchangeapi.controller.exchange;

import com.company.currencyexchangeapi.exception.BadCurrencyCodeException;
import com.company.currencyexchangeapi.exception.NotFoundExchangeRateException;
import com.company.currencyexchangeapi.dto.fail.BadCodeFail;
import com.company.currencyexchangeapi.dto.fail.FailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExchangeRateControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<FailResponse> handleNotFoundExchangeRateException(NotFoundExchangeRateException notFoundExchangeExc) {
        return new ResponseEntity<>(
                new FailResponse(404, notFoundExchangeExc.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<FailResponse> handleBadCurrencyCodeException(BadCurrencyCodeException badCurrencyEx) {
        return new ResponseEntity<>(
                new BadCodeFail(badCurrencyEx.getMessage()), HttpStatus.BAD_REQUEST
        );
    }
}
