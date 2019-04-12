package com.ggh1981.currencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ggh1981.currencies.beans.Retriever;
import com.ggh1981.currencies.beans.RetrieverCurrencyConverterAPIBean;

@SpringBootApplication
//@EnableScheduling
public class CurrenciesRetrieverApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CurrenciesRetrieverApplication.class, args);
		try {
			Retriever retrieverBean = context.getBean(RetrieverCurrencyConverterAPIBean.class);
			retrieverBean.retrieveCurrencies();
			retrieverBean.retrieveRates();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*@Scheduled(fixedRate = 2000)
	public static void scheduleTaskWithFixedRate() {
	    System.out.println("schedule");
	}*/

}
