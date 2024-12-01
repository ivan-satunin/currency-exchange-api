package com.company.currencyexchangeapi.dto.fail;

import org.springframework.http.HttpStatus;

public class NotFoundCodeFail extends FailResponse {

    public NotFoundCodeFail(String detail) {
        super(HttpStatus.NOT_FOUND.value(), detail);
    }
}
