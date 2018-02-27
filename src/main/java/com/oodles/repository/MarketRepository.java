package com.oodles.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oodles.domain.ExchangeCountry;
import com.oodles.domain.Market;

public interface MarketRepository extends JpaRepository<Market, Serializable>
{
	Market findByExchangeCountry(ExchangeCountry exchangecountry);

	Market findByMinLimit(String minLimit);
	

}
