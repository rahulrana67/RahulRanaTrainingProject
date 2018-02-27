package com.oodles.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ExchangeCountry {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	
	@Column
	private Long countryId;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "exchangeCountry")
	@JsonManagedReference
	private List<Market> marketList = new ArrayList<Market>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public List<Market> getMarketList() {
		return marketList;
	}

	public void setMarketList(List<Market> marketList) {
		this.marketList = marketList;
	}
	
}
