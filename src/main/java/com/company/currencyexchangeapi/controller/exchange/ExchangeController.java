package com.company.currencyexchangeapi.controller.exchange;

import com.company.currencyexchangeapi.dto.ExchangeConvertDto;
import com.company.currencyexchangeapi.service.ExchangeConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeConvertService exchangeService;

    @GetMapping
    public ExchangeConvertDto exchangeConvert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount
    ) {
        return exchangeService.convertCurrency(from, to, amount);
    }
}
