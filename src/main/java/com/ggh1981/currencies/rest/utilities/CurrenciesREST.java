package com.ggh1981.currencies.rest.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.ggh1981.currencies.model.Currency;
import com.ggh1981.currencies.model.RatesUSDBased;
import com.ggh1981.currencies.rest.jsontemplates.ResultsJSON;
import com.ggh1981.currencies.rest.parsers.CurrencyParser;

import static com.ggh1981.currencies.common.Configuration.apiKey;

public class CurrenciesREST {
			
	public static List<Currency> getCurrencies() {

		final String URL_CURRENCIES =
				"https://free.currencyconverterapi.com/api/v6/currencies?apiKey={apiKey}";
		@SuppressWarnings("serial")
		Map<String, String> variables = new HashMap<String, String>(){{
			put("apiKey", apiKey);
		}};

		RestTemplate restTemplate = new RestTemplate();
		ResultsJSON resultsJSON = restTemplate.getForObject(URL_CURRENCIES, ResultsJSON.class, variables);

		return CurrencyParser.fromResultsJSONToCurrencies(resultsJSON);
	}

	public static List<RatesUSDBased> getRates(List<String> currenciesId) {

		final String URL_RATES =
				"https://free.currencyconverterapi.com/api/v6/convert?compact={compact}&apiKey={apiKey}&q={q}";
		final String USD_SUFFIX = "_USD";
		final String EMPTY_STRING = "";
		String currentSeparator = ",";
		@SuppressWarnings("serial")
		Map<String, String> variables = new HashMap<String, String>(){{
			put("compact", "ultra");
			put("apiKey", apiKey);
		}};

		StringBuilder qVariable = new StringBuilder();

		for (String currencyId : currenciesId) {
			qVariable.append(currencyId).append(USD_SUFFIX).append(currentSeparator);
			currentSeparator = EMPTY_STRING;
		}
		
		variables.put("q", qVariable.toString());

		RestTemplate restTemplate = new RestTemplate();
		String ratesString = restTemplate.getForObject(URL_RATES,
		String.class, variables);
		
		System.out.println(ratesString);

		return new ArrayList<RatesUSDBased>(); //CurrencyParser.fromResultsJSONToCurrencies(resultsJSON);
	}

}
