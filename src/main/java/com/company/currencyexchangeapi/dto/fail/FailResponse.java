package com.company.currencyexchangeapi.dto.fail;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FailResponse {
    private int statusCode;
    private String detail;
}
