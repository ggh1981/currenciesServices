package com.ggh1981.currencies.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "RATES_USD_BASED")
public class RatesUSDBased {

	public RatesUSDBased() {
		super();
	}

	public RatesUSDBased(String id, Double value) {
		super();
		this.id = id;
		this.value = value;
	}

	@Id
	@Column(length = 3, unique = true, nullable = false)
	private String id;
	private Double value;
	@CreationTimestamp
	private Date date;
	@JsonBackReference
	@OneToOne(mappedBy = "rateUsdBased", fetch = FetchType.LAZY)
	private Currency currency;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
