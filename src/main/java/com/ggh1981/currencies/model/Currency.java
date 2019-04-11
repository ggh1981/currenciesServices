package com.ggh1981.currencies.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCY")
public class Currency {
	
	public Currency() {
		super();
	}

	public Currency(String id, String name, String symbol) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}

	@Id
	@Column(length = 3)
	private String id;
	@Column(length = 250)
	private String name;
	@Column(length = 10)
	private String symbol;
	@OneToMany(mappedBy = "id")
	private List<RatesUSDBased> rates;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
