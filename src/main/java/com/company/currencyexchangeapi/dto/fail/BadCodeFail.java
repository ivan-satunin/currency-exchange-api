package com.company.currencyexchangeapi.dto.fail;

import org.springframework.http.HttpStatus;

public class BadCodeFail extends FailResponse {

    public BadCodeFail(String detail) {
        super(HttpStatus.BAD_REQUEST.value(), detail);
    }
}
