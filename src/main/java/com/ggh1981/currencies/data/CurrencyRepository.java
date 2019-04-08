package com.ggh1981.currencies.data;

import org.springframework.data.repository.CrudRepository;

import com.ggh1981.currencies.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, String>{

}
