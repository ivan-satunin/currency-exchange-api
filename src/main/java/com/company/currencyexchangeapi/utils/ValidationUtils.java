package com.company.currencyexchangeapi.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtils {

    public static boolean isValidCurrencyCode(String code) {
        return code != null && code.matches("[A-Z]{3}");
    }
}
