package com.ggh1981.currencies.rest.jsontemplates;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResultsJSON {

	@JsonProperty("results")
	private Map<String, CurrencyJSON> currencies;

	public Map<String, CurrencyJSON> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, CurrencyJSON> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "ResultsJSON [currencies=" + currencies + "]";
	}
}
