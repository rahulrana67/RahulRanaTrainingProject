package com.oodles.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.repository.RoleRepository;
import com.oodles.constants.Message;
//import com.accounts.service.RoleService;
import com.oodles.domain.Role;

@Service
public class RoleService 
{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MessageService messageService;
	
	Logger LOGGER=LoggerFactory.getLogger(RoleService.class);
	
	
	public Map<String, Object> addRole(String roleName) {

		Map<String, Object> result = new HashMap<String, Object>();
		Boolean isSuccess = false;
		try{
		if (roleName !=null || roleName != ""){
			Role role =  roleRepository.findByRole(roleName);
			if(role == null){
				Role r = new Role();
				r.setRole(roleName);
				roleRepository.save(r);
				isSuccess = true;
				LOGGER.info("Role saved successfully {}", roleName);
				result.put("message", messageService.getMessage(Message.SUCCESS));
			}else {
				result.put("message", messageService.getMessage(Message.ALREADY_EXIST));
			}
		}
		} catch(Exception e){
			LOGGER.warn(e.getMessage());
			result.put("message", messageService.getMessage(Message.INTERNAL_SERVER_ERROR));
		}
		result.put("isSuccess", isSuccess);
		return result;
	}
}
