package com.ggh1981.currencies.rest.utilities;

import static com.ggh1981.currencies.common.Configuration.apiKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.ggh1981.currencies.model.Currency;
import com.ggh1981.currencies.model.RatesUSDBased;
import com.ggh1981.currencies.rest.jsontemplates.ResultsJSON;
import com.ggh1981.currencies.rest.parsers.CurrencyParser;
import com.ggh1981.currencies.rest.parsers.RatesParser;

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

		return new CurrencyParser().restToEntityList(resultsJSON);
	}

	public static List<RatesUSDBased> getRates(List<String> currenciesId) {

		final String URL_RATES =
				"https://free.currencyconverterapi.com/api/v6/convert?compact={compact}&apiKey={apiKey}&q={q}";
		//It is used the prefix because the value will be more accurate
		final String USD_PREFIX = "USD_";
		final String EMPTY_STRING = "";
		String currentSeparator = ",";
		@SuppressWarnings("serial")
		Map<String, String> variables = new HashMap<String, String>(){{
			put("compact", "ultra");
			put("apiKey", apiKey);
		}};

		StringBuilder qVariable = new StringBuilder();

		for (String currencyId : currenciesId) {
			qVariable.append(USD_PREFIX).append(currencyId).append(currentSeparator);
			currentSeparator = EMPTY_STRING;
		}
		
		variables.put("q", qVariable.toString());

		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> ratesMapJSON = restTemplate.getForObject(URL_RATES,
				Map.class, variables);
		
		System.out.println(ratesMapJSON);

		return new RatesParser().restToEntityList(ratesMapJSON);
	}

}
