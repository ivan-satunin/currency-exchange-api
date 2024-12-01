package com.company.currencyexchangeapi.service.impl;

import com.company.currencyexchangeapi.entity.Currency;
import com.company.currencyexchangeapi.exception.NotFoundCurrencyCodeException;
import com.company.currencyexchangeapi.repository.CurrencyRepository;
import com.company.currencyexchangeapi.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Override
    public Iterable<Currency> findAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findByCode(String code) {
        return currencyRepository.findCurrencyByCode(code).orElseThrow(() -> new NotFoundCurrencyCodeException(code));
    }

    @Transactional
    @Override
    public Currency createCurrency(String fullName,
                                   String code,
                                   String sign) {
        return currencyRepository.save(
                Currency.builder()
                        .fullName(fullName)
                        .code(code)
                        .sign(sign)
                        .build()
        );
    }
}
