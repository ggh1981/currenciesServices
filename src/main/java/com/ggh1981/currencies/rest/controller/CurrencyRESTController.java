package com.ggh1981.currencies.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggh1981.currencies.data.CurrencyRepository;
import com.ggh1981.currencies.model.Currency;

@RestController
public class CurrencyRESTController {

	@Autowired
	private CurrencyRepository repository;

	@RequestMapping("/currencies")
	public List<Currency> getAllCurrenciesRates() {
		List<Currency> currencies = new ArrayList<Currency>();
		repository.findAll().forEach(currencies::add);
		return currencies;
	}

}
