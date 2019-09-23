package com.sachin.tutorial.repository;

import com.sachin.tutorial.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    List<Currency> findAll();

    Currency findCurrencyByCcyCode(String ccyCode);
}
