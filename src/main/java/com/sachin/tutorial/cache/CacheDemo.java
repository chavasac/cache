package com.sachin.tutorial.cache;

import com.google.common.cache.LoadingCache;
import com.sachin.tutorial.domain.Currency;

import java.util.concurrent.ExecutionException;

public class CacheDemo {

    public static void main(String[] args) {
        try {
            CacheDemo cacheDemo = new CacheDemo();
            //Access currency first time with id 1, getCurrencyByCode() will be called.
            System.out.println(cacheDemo.getCurrencyByCode("INR").getCurrency());
            System.out.println("------------------------");
            //Access currency second time with id 1, getCurrencyByCode() will be not called.
            //Data is cached.
            System.out.println(cacheDemo.getCurrencyByCode("INR").getCurrency());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Currency getCurrencyByCode(String ccyCode) throws ExecutionException {
        LoadingCache<String, Currency> empCache = CurrencyCache.getCache();
        //System.out.println(empCache.stats());
        System.out.println("Cache Size:" + empCache.size());
        return empCache.get(ccyCode);
    }
}
