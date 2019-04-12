package com.ggh1981.currencies.scheduledtasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ggh1981.currencies.beans.RetrieverCurrencyConverterAPIBean;

@Component
@EnableScheduling
public class CurrencyRetriever {

	@Autowired
	private RetrieverCurrencyConverterAPIBean retriever;

	@Scheduled(fixedDelay = 3600000, initialDelay = 30000)
	public void scheduleTaskWithFixedRate() {
		try {
			retriever.retrieveCurrencies();
			retriever.retrieveRates();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
