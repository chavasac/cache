package com.sachin.tutorial.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sachin.tutorial.domain.Currency;

import java.util.concurrent.TimeUnit;

public class CurrencyCache {

    private static LoadingCache<String, Currency> cache;

    static {
        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(1000, TimeUnit.MINUTES)
                .build(
                        new CacheLoader<String, Currency>() {
                            @Override
                            public Currency load(String ccyCode) throws Exception {
                                return getCurrencyByCode(ccyCode);
                            }
                        }
                );
    }

    public static LoadingCache<String, Currency> getCache() {
        return cache;
    }

    public static Currency getCurrencyByCode(String ccyCode) {
        System.out.println("--Executing getCurrencyByCode--");
        //Perform any expensive task like fetching data from Database.
        Currency INR = new Currency("INR", "Indial Rupee", 1.0f);
        Currency USD = (new Currency("USD", "US Dollar", 2.0f));

        if(ccyCode.equalsIgnoreCase("INR")) {
            return INR;
        } else {
            return USD;
        }
    }
}
