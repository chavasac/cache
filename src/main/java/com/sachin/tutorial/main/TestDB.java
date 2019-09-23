package com.sachin.tutorial.main;

import com.sachin.tutorial.domain.Currency;
import com.sachin.tutorial.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDB {

    private static final Logger LOG = LoggerFactory.getLogger(TestDB.class);

    @Autowired
    private CurrencyService currencyService;

    @Bean
    public void testAllDbConfiguration() {

        LOG.info("Started inserting currencies...");
        currencyService.insertCurrencies();
        LOG.info("Inserted currencies successfully...");

        LOG.info("Retrieving all currency records");
        List<Currency> currencies = currencyService.getAllCurrencies();
        LOG.info("Total {} currencies are available", currencies.size());
        for(Currency ccy: currencies) {
            LOG.info("Currency is {}", ccy);
        }

        LOG.info("Find currency recode for code {}", "INR");
        Currency currency = currencyService.getCcyFromCode("INR");
        LOG.info("Currency record for INR is : {}", currency);
    }
}
