package com.oodles.controller;

import java.util.Map;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oodles.dto.MarketDTO;
import com.oodles.mapping.URLMapping;
import com.oodles.util.ResponseHandler;
import com.oodles.services.MarketService;

@RestController
public class MarketController 
{
	 @Autowired
	    MarketService marketService;

	 String message="message";
	 
	 Logger LOGGER=org.slf4j.LoggerFactory.getLogger(MarketController.class);
	 
	 @RequestMapping(value = URLMapping.SAVE_MARKET, method = RequestMethod.POST)
	    ResponseEntity<Object> saveMarket(@RequestBody MarketDTO marketForm) {
	        Map<String, Object> result = null;
	        try {
	        	LOGGER.info("controller");
	        	LOGGER.info(""+marketForm.getExchangeCountryId());
	        	LOGGER.info(""+marketForm.getMinLimit());
	            result = marketService.saveMarket(marketForm);
	            if(result.get("isSuccess").equals(true)){
	                return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get(message).toString(), result);
	            }
	            else
	                return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get(message).toString(), result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
	        }
	    }
	 
	 @RequestMapping(value = URLMapping.GET_MARKET, method = RequestMethod.GET)
	 ResponseEntity<Object> getMarket(@RequestParam String marketId) {
	        Map<String, Object> result = null;
	        try {
	            result = marketService.getMarket(marketId);
	            if(result.get("isSuccess").equals(true)){
	                return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get(message).toString(), result);
	            }
	            else
	                return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get(message).toString(), result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
	        }
	    }
	 
	 
	 
}
