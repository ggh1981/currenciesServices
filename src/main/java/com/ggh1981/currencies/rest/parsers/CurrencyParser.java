package com.ggh1981.currencies.rest.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ggh1981.currencies.model.Currency;
import com.ggh1981.currencies.rest.jsontemplates.CurrencyJSON;
import com.ggh1981.currencies.rest.jsontemplates.ResultsJSON;

public class CurrencyParser implements ParserBase<Currency, ResultsJSON>{

	@Override
	public List<Currency> restToEntityList(ResultsJSON json) {
		List<Currency> currencies = new ArrayList<Currency>();
		Currency currency = null;
		CurrencyJSON currencyJSON = null;
		for (Map.Entry<String, CurrencyJSON> currencyEntry : json.getCurrencies().entrySet()) {
			currencyJSON = currencyEntry.getValue();
			currency = new Currency(currencyJSON.getId(), currencyJSON.getCurrencyName(),
					currencyJSON.getCurrencySymbol());
			currencies.add(currency);
		}
		return currencies;
	}
}
