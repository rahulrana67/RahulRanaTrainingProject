package com.oodles.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.repository.MarketRepository;
import com.oodles.repository.ExchangeCountryRepository;

import com.oodles.domain.ExchangeCountry;
import com.oodles.services.MarketService;
import com.oodles.domain.Market;
import com.oodles.dto.MarketDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MarketService {
	@Autowired
	MarketRepository marketRepository;
	
	Logger LOGGER = LoggerFactory.getLogger(MarketService.class);

	@Autowired
	ExchangeCountryRepository exchangeCountryRepository;

	public Map<String, Object> saveMarket(MarketDTO marketForm) {
		Map<String, Object> result = new HashMap<>();

		LOGGER.info("asd+++++++++++++");

		ExchangeCountry exchangeCountry = exchangeCountryRepository.findOne(marketForm.getExchangeCountryId());

		if (exchangeCountry == null) {

			LOGGER.info("Exchange Country doesnot exist========000000000");

			result.put("isSuccess", false);
			return result;
		}

		LOGGER.info("Exchange country is   ====== " + exchangeCountry.getCountryId());

		try {

			LOGGER.info("Market  is  ======== == = -- ====== ");

			Market exist = marketRepository.findByMinLimit(marketForm.getMinLimit());

			if (exist != null) 
			{
				LOGGER.info("Market already exist+----------------------");
				result.put("isSuccess", false);
				return result;
			}

			Market nn = new Market();

			result.put("isSuccess", true);
			nn.setExchangeCountry(exchangeCountry);
			nn.setMinLimit(marketForm.getMinLimit());
			LOGGER.info("Market creatingggggggggggggg------+----------------------");
			marketRepository.save(nn);
			LOGGER.info("Market created------------------+----------------------");

		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
			LOGGER.info("EXception--------------==========++++++++++");
			result.put("isSuccess", false);
		}

		return result;
	}

	private Market getMarket(MarketDTO marketForm) {

		Market market = new Market();

		try {
			// Double d= Double.parseDouble(marketForm.getMinLimit());

			// market.setFeeMode(marketForm.getFeeMode());
			market.setMinLimit(marketForm.getMinLimit());
			// market.setLimitMakerFee(marketForm.getLimitMakerFee());
			// market.setLimitTakerFee(marketForm.getLimitTakerFee());
			// market.setNominalMakerFee(marketForm.getNominalMakerFee());
			// market.setNominalTakerFee(marketForm.getNominalTakerFee());
			// market.setSortOrder(marketForm.getSortOrder());
			// market.setSpread(marketForm.getSpread());
			market.setActive(true);

		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return market;
	}

	public Map<String, Object> getMarket(String marketId) {

		Map<String, Object> result = new HashMap<String, Object>();
		Boolean isSuccess = false;
		Market market = marketRepository.findOne(Long.parseLong(marketId));

		try {
			if (market == null) {
				result.put("isSuccess", isSuccess);

				LOGGER.info("Don't have Market for this given Id ....");
				return result;
			}
			isSuccess = true;
			result.put("isSuccess", isSuccess);

			LOGGER.info("Market details fetched successfully ....");
			result.put("market", market);

		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
			result.put("isSuccess", isSuccess);
		}
		return result;

	}

}
