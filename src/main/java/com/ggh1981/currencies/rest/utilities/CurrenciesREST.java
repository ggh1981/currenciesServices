package com.ggh1981.currencies.rest.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ggh1981.currencies.model.Currency;
import com.ggh1981.currencies.model.RatesUSDBased;
import com.ggh1981.currencies.rest.jsontemplates.ResultsJSON;
import com.ggh1981.currencies.rest.parsers.CurrencyParser;

public class CurrenciesREST {

	public static List<Currency> getCurrencies() {

		final String URL_CURRENCIES = "https://free.currencyconverterapi.com/api/v6/currencies?apiKey=c9ec3f8efa4debc457a4";

		List<Currency> currencies = new ArrayList<Currency>();

		RestTemplate restTemplate = new RestTemplate();
		ResultsJSON resultsJSON = restTemplate.getForObject(URL_CURRENCIES, ResultsJSON.class);

		return CurrencyParser.fromResultsJSONToCurrencies(resultsJSON);
	}

	public static List<RatesUSDBased> getRates(List<String> currenciesId) {
		
		final String URL_RATES = "https://free.currencyconverterapi.com/api/v6/convert?compact=ultra&apiKey=c9ec3f8efa4debc457a4&q=";
		final String USD_SUFFIX = "_USD";
		final String EMPTY_STRING = "";
		String currentSeparator = ",";
		
		StringBuilder urlRatesWithParameters = new StringBuilder(URL_RATES);
		List<Currency> currencies = new ArrayList<Currency>();
		
		for(String currencyId : currenciesId) {
			urlRatesWithParameters.append(URL_RATES).append(currencyId).append(USD_SUFFIX).append(currentSeparator);
			currentSeparator = EMPTY_STRING;
		}

		System.out.println(urlRatesWithParameters.toString());
		
		//RestTemplate restTemplate = new RestTemplate();
		//ResultsJSON resultsJSON = restTemplate.getForObject(URL_CURRENCIES, ResultsJSON.class);

		return null; // CurrencyParser.fromResultsJSONToCurrencies(resultsJSON);
	}

}
