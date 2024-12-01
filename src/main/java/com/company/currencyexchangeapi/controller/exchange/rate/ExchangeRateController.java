package com.company.currencyexchangeapi.controller.exchange.rate;

import com.company.currencyexchangeapi.controller.exchange.rate.payload.UpdateExchangeRatePayload;
import com.company.currencyexchangeapi.entity.ExchangeRate;
import com.company.currencyexchangeapi.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exchangeRate/{baseAndTargetCode:[A-Z]{6}}")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping
    public ExchangeRate findByBaseAndTargetCode(
            @PathVariable String baseAndTargetCode
    ) {
        return exchangeRateService.findByBaseAndTargetCode(baseAndTargetCode);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    public ExchangeRate updateExchangeRate(
            @PathVariable String baseAndTargetCode,
            @RequestBody UpdateExchangeRatePayload updatePayload
    ) {
        return exchangeRateService.update(baseAndTargetCode, updatePayload.rate());
    }
}