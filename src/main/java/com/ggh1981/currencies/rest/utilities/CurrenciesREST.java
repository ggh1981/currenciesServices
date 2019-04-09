package com.ggh1981.currencies.rest.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.ggh1981.currencies.model.Currency;
import com.ggh1981.currencies.model.RatesUSDBased;
import com.ggh1981.currencies.rest.jsontemplates.ResultsJSON;
import com.ggh1981.currencies.rest.parsers.CurrencyParser;

public class CurrenciesREST {
	
	@Value("${currency.apiKey}")
	private static String apiKey;

	public static List<Currency> getCurrencies() {

		final String URL_CURRENCIES = "https://free.currencyconverterapi.com/api/v6/currencies";
		@SuppressWarnings("serial")
		Map<String, String> variables = new HashMap<String, String>(){{
			put("apiKey", apiKey);
		}};
		List<Currency> currencies = new ArrayList<Currency>();

		RestTemplate restTemplate = new RestTemplate();
		ResultsJSON resultsJSON = restTemplate.getForObject(URL_CURRENCIES, ResultsJSON.class, variables);

		return CurrencyParser.fromResultsJSONToCurrencies(resultsJSON);
	}

	public static List<RatesUSDBased> getRates(List<String> currenciesId) {

		final String URL_RATES = "https://free.currencyconverterapi.com/api/v6/convert";
		final String USD_SUFFIX = "_USD";
		final String EMPTY_STRING = "";
		String currentSeparator = ",";
		@SuppressWarnings("serial")
		Map<String, String> variables = new HashMap<String, String>(){{
			put("compact", "ultra");
			put("apiKey", apiKey);
		}};

		StringBuilder qVariable = new StringBuilder();
		List<Currency> currencies = new ArrayList<Currency>();

		for (String currencyId : currenciesId) {
			qVariable.append(currencyId).append(USD_SUFFIX).append(currentSeparator);
			currentSeparator = EMPTY_STRING;
		}

		System.out.println(qVariable.toString());

		// RestTemplate restTemplate = new RestTemplate();
		// ResultsJSON resultsJSON = restTemplate.getForObject(URL_CURRENCIES,
		// ResultsJSON.class, variables);

		return null; // CurrencyParser.fromResultsJSONToCurrencies(resultsJSON);
	}

}
