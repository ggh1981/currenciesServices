package com.ggh1981.currencies.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

	public static String apiKey;

	@Value("${currency.apiKey}")
	public void setApiKey(String apiKey) {
		Configuration.apiKey = apiKey;
	}

}
