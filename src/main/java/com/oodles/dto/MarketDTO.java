package com.oodles.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MarketDTO 
{
	
	private String minLimit;
   
    private Boolean isActive;
    
    private Long exchangeCountryId;

    
	
	
	public String getMinLimit() {
		return minLimit;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public Long getExchangeCountryId() {
		return exchangeCountryId;
	}
}
