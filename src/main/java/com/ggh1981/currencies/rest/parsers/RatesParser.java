package com.ggh1981.currencies.rest.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ggh1981.currencies.model.RatesUSDBased;

public class RatesParser implements ParserBase<RatesUSDBased, Map<String, Object>> {

	@Override
	public List<RatesUSDBased> restToEntityList(Map<String, Object> ratesJSON) {
		List<RatesUSDBased> ratesUSDBasedList = new ArrayList<RatesUSDBased>();

		for (Map.Entry<String, Object> rate : ratesJSON.entrySet()) {
			ratesUSDBasedList
					.add(new RatesUSDBased(rate.getKey().split("_")[1], Double.valueOf(rate.getValue().toString())));
		}
		return ratesUSDBasedList;
	}
}
