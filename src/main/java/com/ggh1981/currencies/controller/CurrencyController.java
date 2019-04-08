package com.ggh1981.currencies.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ggh1981.currencies.data.CurrencyRepository;
import com.ggh1981.currencies.data.RateRepository;
import com.ggh1981.currencies.model.Currency;
import com.ggh1981.currencies.model.RatesUSDBased;
import com.ggh1981.currencies.rest.utilities.CurrenciesREST;

@Controller
public class CurrencyController {
	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private RateRepository rateRepository;

	public void retrieveCurrencies() {
		List<Currency> currencies = CurrenciesREST.getCurrencies();
		currencyRepository.saveAll(currencies);
	}

	public void retrieveRates() {
		String RATE_USD = "USD";

		List<String> twoCurrencies = new ArrayList<String>(2);
		String currencyId = null;
		for (Currency currency : currencyRepository.findAll()) {
			currencyId = currency.getId();
			if (currencyId.equalsIgnoreCase(RATE_USD)) {
				twoCurrencies.add(currency.getId());
				if (twoCurrencies.size() >= 2) {
					rateRepository.saveAll(CurrenciesREST.getRates(twoCurrencies));
					twoCurrencies = new ArrayList<String>();
				}
			}
		}
		if(!twoCurrencies.isEmpty()) {
			rateRepository.saveAll(CurrenciesREST.getRates(twoCurrencies));
		}
	}

}
