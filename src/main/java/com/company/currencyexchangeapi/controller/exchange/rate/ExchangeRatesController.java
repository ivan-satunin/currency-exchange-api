package com.company.currencyexchangeapi.controller.exchange.rate;

import com.company.currencyexchangeapi.controller.exchange.rate.payload.NewExchangeRatePayload;
import com.company.currencyexchangeapi.entity.ExchangeRate;
import com.company.currencyexchangeapi.exception.BadCurrencyCodeException;
import com.company.currencyexchangeapi.service.impl.ExchangeRateServiceImpl;
import com.company.currencyexchangeapi.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exchangeRates")
public class ExchangeRatesController {

    private final ExchangeRateServiceImpl exchangeRateService;

    @GetMapping
    public Iterable<ExchangeRate> findExchangeRates() {
        return exchangeRateService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ExchangeRate createExchangeRate(@RequestBody NewExchangeRatePayload payload) {
        var baseCode = payload.baseCurrencyCode();
        var targetCode = payload.targetCurrencyCode();
        if (!ValidationUtils.isValidCurrencyCode(baseCode))
            throw new BadCurrencyCodeException(baseCode);
        if (!ValidationUtils.isValidCurrencyCode(targetCode))
            throw new BadCurrencyCodeException(targetCode);
        return exchangeRateService.create(baseCode, targetCode, payload.rate());
    }
}
