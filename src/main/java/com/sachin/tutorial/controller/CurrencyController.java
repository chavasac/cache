package com.sachin.tutorial.controller;

import com.sachin.tutorial.domain.Currency;
import com.sachin.tutorial.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<Currency>> getAllcurrencys() {
        List<Currency> list = currencyService.getAllCurrencies();

        return new ResponseEntity<List<Currency>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{ccyCode}")
    public ResponseEntity<Currency> getcurrencyByCode(@PathVariable("ccyCode") String ccyCode){
        Currency entity = currencyService.getCcyFromCode(ccyCode);
        return new ResponseEntity<Currency>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Currency> createOrUpdatecurrency() {
        currencyService.insertCurrencies();
        return new ResponseEntity<Currency>(new Currency(), new HttpHeaders(), HttpStatus.OK);
    }
}
