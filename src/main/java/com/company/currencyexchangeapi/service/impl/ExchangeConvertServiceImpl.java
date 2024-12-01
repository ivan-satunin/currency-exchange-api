package com.company.currencyexchangeapi.service.impl;

import com.company.currencyexchangeapi.entity.ExchangeRate;
import com.company.currencyexchangeapi.dto.ExchangeConvertDto;
import com.company.currencyexchangeapi.exception.NotFoundExchangeRateException;
import com.company.currencyexchangeapi.service.ExchangeConvertService;
import com.company.currencyexchangeapi.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExchangeConvertServiceImpl implements ExchangeConvertService {
    private static final String USD_CODE = "USD";

    private final ExchangeRateService exchangeRateService;

    @Override
    public ExchangeConvertDto convertCurrency(String baseCode, String targetCode, double amount) {
        var exchangeRate = defineExchangeRate(baseCode, targetCode);
        var rate = exchangeRate.getRate();
        return new ExchangeConvertDto(
                exchangeRate.getBaseCurrency(), exchangeRate.getTargetCurrency(), rate,
                amount, convertAmount(rate, amount)
        );
    }

    private ExchangeRate defineExchangeRate(String baseCode, String targetCode) {
        if (exchangeRateService.existsByBaseAndTargetCode(baseCode, targetCode))
            return exchangeRateService.findByBaseAndTargetCode(baseCode, targetCode);
        else if (exchangeRateService.existsByBaseAndTargetCode(targetCode, baseCode))
            return exchangeRateService.findByBaseAndTargetCode(targetCode, baseCode);
        else if (
                exchangeRateService.existsByBaseAndTargetCode(USD_CODE, baseCode)
                        && exchangeRateService.existsByBaseAndTargetCode(USD_CODE, targetCode)
        )
            return buildCrossUsdExchangeRate(baseCode, targetCode);
        throw new NotFoundExchangeRateException(baseCode, targetCode);
    }

    private ExchangeRate buildCrossUsdExchangeRate(String baseCode, String targetCode) {
        var usdToBaseExchangeRate = exchangeRateService.findByBaseAndTargetCode(USD_CODE, baseCode);
        var usdToTargetExchangeRate = exchangeRateService.findByBaseAndTargetCode(USD_CODE, targetCode);
        return ExchangeRate.builder()
                .baseCurrency(usdToBaseExchangeRate.getTargetCurrency())
                .targetCurrency(usdToTargetExchangeRate.getTargetCurrency())
                .rate(usdToTargetExchangeRate.getRate() / usdToBaseExchangeRate.getRate())
                .build();
    }

    private double convertAmount(double amount, double rate) {
        return amount * rate;
    }
}
