package com.ggh1981.currencies.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ggh1981.currencies.controller.CurrencyController;

@Component
public class RetrieverCurrencyConverterAPIBean implements Retriever{
	
	@Autowired
	CurrencyController controller;

	@Override
	public void retrieveCurrencies() {
		controller.retrieveCurrencies();
	}

	@Override
	public void retrieveRates() {
		controller.retrieveRates();
	}


}
