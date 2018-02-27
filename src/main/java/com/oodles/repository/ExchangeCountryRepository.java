package com.oodles.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.oodles.domain.ExchangeCountry;

public interface ExchangeCountryRepository extends JpaRepository<ExchangeCountry, Serializable> 
{
	ExchangeCountry findByCountryId(Long countryId);
	
}
