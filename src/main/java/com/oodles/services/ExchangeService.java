package com.oodles.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.repository.ExchangeCountryRepository;
//import com.oodles.service.ActivityService;
//import com.accounts.constants.Message;
//import com.oodles.domain.Country;
import com.oodles.domain.ExchangeCountry;

@Service
public class ExchangeService
{
    private static Logger LOGGER = LoggerFactory.getLogger(ExchangeService.class);

	@Autowired
    ExchangeCountryRepository exchangeCountryRepository;

	public Map<String, Object> saveExchange(ExchangeCountry data) 
	{
		Map<String, Object> result = new HashMap<String, Object>();
        Boolean isSuccess = false;
        ExchangeCountry isExist=null;
        ExchangeCountry exchangeCountry = new ExchangeCountry();

        try{
            
        	Long id=Long.parseLong(data.getCountryId().toString());
            isExist=exchangeCountryRepository.findByCountryId(id);

            if(isExist==null){
                exchangeCountry.setCountryId(id);
                
                ExchangeCountry savedExchangeCountry = exchangeCountryRepository.save(exchangeCountry);
                LOGGER.info("Exchange country saved successfully {}", savedExchangeCountry);
                isSuccess = true;
                result.put("isSuccess", isSuccess);
                return result;
            }

            result.put("isSuccess", isSuccess);

        }catch(Exception e)
        {
            LOGGER.warn(e.getMessage());
            result.put("isSuccess", isSuccess);
        }

        return result;
    }
	
	public Map<String, Object> getExchange(String exchangeId)
	{
		Map<String, Object> result = new HashMap<String, Object>();
        Boolean isSuccess = false;
        ExchangeCountry exchangeCountry=exchangeCountryRepository.findOne(Long.parseLong(exchangeId));

        
        try{

            if(exchangeCountry==null){
                result.put("isSuccess", isSuccess);
               // result.put("message", messageService.getMessage(Message.SUCCESS));
                LOGGER.info("No exchange country found for given exchangeId");
                return result;
            }
            //LOGGER.info("exchangeCountry.getTradeBlockDateTime()"+ exchangeCountry.getTradeBlockDateTime());
            isSuccess=true;
            result.put("isSuccess", isSuccess);
            //result.put("message", messageService.getMessage(Message.SUCCESS));
            result.put("exchangeCountry", exchangeCountry);
            /*result.put("tradeBlockHours", exchangeCountry.getTradeBlockDateTime().getHours());
            result.put("tradeBlockMinutes", exchangeCountry.getTradeBlockDateTime().getMinutes());
            result.put("loginBlockHours", exchangeCountry.getLoginBlockDateTime().getHours());
            result.put("loginBlockMinutes", exchangeCountry.getLoginBlockDateTime().getMinutes());
            */
            LOGGER.info("Exchange fetched successfully");

        }catch (Exception e) {
            LOGGER.warn(e.getMessage());
            result.put("isSuccess", isSuccess);
         //   result.put("message", messageService.getMessage(Message.INTERNAL_SERVER_ERROR));
        }

        return result;		
	}

}