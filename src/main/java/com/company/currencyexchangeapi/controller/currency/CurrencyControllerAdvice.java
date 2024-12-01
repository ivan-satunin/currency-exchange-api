package com.company.currencyexchangeapi.controller.currency;

import com.company.currencyexchangeapi.dto.fail.NotFoundCodeFail;
import com.company.currencyexchangeapi.exception.NotFoundCurrencyCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CurrencyControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<NotFoundCodeFail> handleBadCurrencyCodeException(NotFoundCurrencyCodeException badCodeException) {
//        return ResponseEntity.of(
//                ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()), badCodeException.getMessage())
//        ).build();
        return new ResponseEntity<>(new NotFoundCodeFail(badCodeException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
