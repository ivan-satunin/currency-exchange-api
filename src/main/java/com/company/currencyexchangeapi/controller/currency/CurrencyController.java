package com.company.currencyexchangeapi.controller.currency;

import com.company.currencyexchangeapi.entity.Currency;
import com.company.currencyexchangeapi.service.CurrencyService;
import com.company.currencyexchangeapi.service.impl.CurrencyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("currency/{code:[A-Z]{3}}")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping
    public Currency findCurrency(@PathVariable String code) {
        return currencyService.findByCode(code);
    }
}
