package com.company.currencyexchangeapi.service.impl;

import com.company.currencyexchangeapi.entity.ExchangeRate;
import com.company.currencyexchangeapi.exception.CreateUpdateExchangeRateException;
import com.company.currencyexchangeapi.exception.NotFoundCurrencyCodeException;
import com.company.currencyexchangeapi.exception.NotFoundExchangeRateException;
import com.company.currencyexchangeapi.repository.ExchangeRateRepository;
import com.company.currencyexchangeapi.service.CurrencyService;
import com.company.currencyexchangeapi.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final CurrencyService currencyService;

    @Override
    public Iterable<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }

    @Override
    public ExchangeRate findByBaseAndTargetCode(String baseCode, String targetCode) {
        return exchangeRateRepository.findByBaseAndTargetCode(baseCode, targetCode)
                .orElseThrow(() -> new NotFoundExchangeRateException(baseCode, targetCode));
    }

    @Transactional
    @Override
    public ExchangeRate create(
            String baseCurrencyCode,
            String targetCurrencyCode,
            double rate
    ) {
        try {
            var newExchangeRate = ExchangeRate.builder()
                    .baseCurrency(currencyService.findByCode(baseCurrencyCode))
                    .targetCurrency(currencyService.findByCode(targetCurrencyCode))
                    .rate(rate)
                    .build();
            return exchangeRateRepository.save(newExchangeRate);
        } catch (NotFoundCurrencyCodeException notFoundCodeEx) {
            throw new CreateUpdateExchangeRateException("No currency codes: " + baseCurrencyCode + "->" + targetCurrencyCode, notFoundCodeEx);
        }
    }

    @Transactional
    @Override
    public ExchangeRate update(String baseAndTargetCode, double rate) {
        var exchangeRate = findByBaseAndTargetCode(baseAndTargetCode);
        exchangeRate.setRate(rate);
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public boolean existsByBaseAndTargetCode(String baseCode, String targetCode) {
        return exchangeRateRepository.existsByBaseAndTargetCode(baseCode, targetCode);
    }
}
