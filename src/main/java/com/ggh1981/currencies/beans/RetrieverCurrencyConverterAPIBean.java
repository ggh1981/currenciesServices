package com.ggh1981.currencies.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ggh1981.currencies.controller.CurrencyController;

@Component
public class RetrieverCurrencyConverterAPIBean {

	@Autowired
	CurrencyController controller;

	public void retrieveCurrencies() {
		controller.retrieveCurrencies();
	}

	public void retrieveRates() {
		controller.retrieveRates();
	}

}
