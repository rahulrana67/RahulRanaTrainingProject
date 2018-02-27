package com.oodles.domain;

import java.math.BigDecimal;
import java.util.Date;import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Market 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	private String minLimit;
	
	private Boolean isActive = true;
	

	@ManyToOne
	@JoinColumn(name = "country_id")
	@JsonBackReference
    private ExchangeCountry exchangeCountry;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(String minLimit) {
		this.minLimit = minLimit;
	}

	
	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}
	
	public ExchangeCountry getExchangeCountry() {
		return exchangeCountry;
	}

	public void setExchangeCountry(ExchangeCountry exchangeCountry) {
		this.exchangeCountry = exchangeCountry;
	}

	
}
