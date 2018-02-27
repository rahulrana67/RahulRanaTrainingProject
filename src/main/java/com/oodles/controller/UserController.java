package com.oodles.controller;

import java.util.List;
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
import com.oodles.util.ResponseHandler;
import com.oodles.domain.User;
import com.oodles.dto.UserDTO;
import com.oodles.mapping.URLMapping;
import com.oodles.services.UserService;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	 Logger LOGGER=org.slf4j.LoggerFactory.getLogger(MarketController.class);
	 
	 String message="message";
	
    @RequestMapping(value = URLMapping.ADD_USER, method = RequestMethod.POST)
    ResponseEntity<Object> saveUser(@RequestBody User user) {
    	LOGGER.info("------------------------------------------------------------"+user);
        Map<String, Object> result = null;
        try {
            result = userService.saveUser(user);
            if(result.get("isSuccess").equals(true)){
                return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get(message).toString(), result);
            }
            else
                return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get(message).toString(), result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
        }
    }
    
    @RequestMapping(value=URLMapping.GET_USER, method= RequestMethod.GET)
	public ResponseEntity<Object>getUserProfile() {

		LOGGER.info("getUserProfile ");//email);
		 List<User>user=userService.getUser();
		if (user != null) 
		{
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "User data is retrived", user);
		} 
		else {
			return ResponseHandler.generateResponse(HttpStatus.OK, false, "User data is not retrived", user);
		}
	}
    
    @RequestMapping(value = URLMapping.UPDATE_USER, method = RequestMethod.PUT)
    public ResponseEntity<Object>updateUser(@RequestParam Long userId, @RequestBody UserDTO user)
    {
        Map<String, Object> result = null;
        result = userService.updateUser(userId, user);
        
        try {
            result = userService.updateUser(userId, user);
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
