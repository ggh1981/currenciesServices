package com.ggh1981.currencies.rest.jsontemplates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CurrencyJSON {
	private String currencyName;
	private String currencySymbol;
	private String id;

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CurrenciesJSON [currencyName=" + currencyName + ", currencySymbol=" + currencySymbol + ", id=" + id
				+ "]";
	}

}
