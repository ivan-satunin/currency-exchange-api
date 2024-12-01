package com.company.currencyexchangeapi.controller.currency;

import com.company.currencyexchangeapi.controller.currency.payload.NewCurrencyPayload;
import com.company.currencyexchangeapi.entity.Currency;
import com.company.currencyexchangeapi.service.impl.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencies")
public class CurrenciesController {
    private final CurrencyServiceImpl currencyService;

    @GetMapping
    public Iterable<Currency> findCurrencies() {
        return currencyService.findAllCurrencies();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Currency createCurrency(@RequestBody NewCurrencyPayload payload) {
        return currencyService.createCurrency(payload.name(), payload.code(), payload.sign());
    }
}
