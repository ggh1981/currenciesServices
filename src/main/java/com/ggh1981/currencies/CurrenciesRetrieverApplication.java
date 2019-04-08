package com.ggh1981.currencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ggh1981.currencies.beans.Retriever;
import com.ggh1981.currencies.beans.RetrieverCurrencyConverterAPIBean;

@SpringBootApplication
public class CurrenciesRetrieverApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CurrenciesRetrieverApplication.class, args);
		/*if (args.length == 0) {
			System.out.println("No parameter received");
		} else  if (args[0].equalsIgnoreCase("currencies")) {*/
			Retriever retrieverBean = context.getBean(RetrieverCurrencyConverterAPIBean.class);
			retrieverBean.retrieveCurrencies();
		/*} else if (args[0].equalsIgnoreCase("rates")) {
			Retriever retrieverBean = context.getBean(RetrieverCurrencyConverterAPIBean.class);*/
			retrieverBean.retrieveRates();
			/*System.out.println("Result " + );
		} else {
			System.out.println("Unknown parameter");
		}*/
	}

}
