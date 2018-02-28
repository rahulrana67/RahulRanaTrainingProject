package com.oodles.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oodles.services.RoleService;
import com.oodles.mapping.URLMapping;
import com.oodles.util.Activity;
import com.oodles.util.ResponseHandler;

@RestController
public class RoleController 
{
	
	
	@Autowired
	RoleService roleService;
	
	@Activity
	@RequestMapping(value = URLMapping.ADD_ROLE, method = RequestMethod.POST)
	public ResponseEntity<Object> addRole(@RequestBody String role) {
		Map<String, Object> result = null;
		try {
			result = roleService.addRole(role);
			if(result.get("isSuccess").equals(true)){
			return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get("message").toString(), result);
			}
			else
				return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get("message").toString(), result);		
		} catch (Exception e) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
		}
	}
	
	
}
