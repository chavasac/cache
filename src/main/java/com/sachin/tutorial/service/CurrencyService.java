package com.sachin.tutorial.service;

import com.sachin.tutorial.domain.Currency;
import com.sachin.tutorial.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCcyFromCode(String ccyCode) {
        return currencyRepository.findCurrencyByCcyCode(ccyCode);
    }

    public void insertCurrencies() {
        currencyRepository.save(new Currency("INR", "Indial Rupee", 1.0f));
        currencyRepository.save(new Currency("USD", "US Dollar", 2.0f));
        currencyRepository.save(new Currency("GBP", "Great Britain Pound", 3.0f));
        currencyRepository.save(new Currency("EUR", "Euro", 4.0f));
        currencyRepository.save(new Currency("JPY", "Japanese Yen", 1.2f));
    }
}
