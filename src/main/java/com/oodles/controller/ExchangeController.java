package com.oodles.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oodles.services.ExchangeService;
import com.oodles.domain.ExchangeCountry;
import com.oodles.mapping.URLMapping;
import com.oodles.util.ResponseHandler;

@RestController
public class ExchangeController 
{
	
	@Autowired
    ExchangeService exchangeService;

	String message="message";
	
	@RequestMapping(value = URLMapping.ADD_EXCHANGE, method = RequestMethod.POST)
    ResponseEntity<Object> saveExchange(@RequestBody ExchangeCountry data) {
        Map<String, Object> result = null;
        try {
           
            result = exchangeService.saveExchange(data);
            if(result.get("isSuccess").equals(true)){
                return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get(message).toString(), result);
            }
            else
                return ResponseHandler.generateResponse(HttpStatus.OK, false, result.get(message).toString(), result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
        }
    }
	
	 @RequestMapping(value = URLMapping.GET_EXCHANGE, method = RequestMethod.GET)
	    ResponseEntity<Object> getExchange(@RequestParam String countryId) {
	        Map<String, Object> result = null;
	        try {
	            result = exchangeService.getExchange(countryId);
	            if(result.get("isSuccess").equals(true)){
	                return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get(message).toString(), result);
	            }
	            else
	                return ResponseHandler.generateResponse(HttpStatus.OK, false, result.get(message).toString(), result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
	        }
	    }
	
}
