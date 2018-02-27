package com.oodles.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.domain.User;
import com.oodles.dto.UserDTO;
import com.oodles.repository.UserRepository;


@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;
	
	public Map<String,Object> saveUser(User user)
	{
		String user1 = user.getEmail();
		System.out.println("----------------------------------------"+user1);
		Map<String, Object> result = new HashMap<String, Object>();
        Boolean isSuccess = false;
        User usr=new User();
        usr.setEmail(user.getEmail());
        usr.setId(user.getId());
        usr.setName(user.getName());
        usr.setDob(user.getDob());
        usr.setGender(user.getGender());
        usr.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(usr);
        
       
        	result.put("isSuccess", isSuccess);
        	result.put("data", usr);
        	return result;
	}
	
	public List<User> getUser() {
		List<User> user = userRepository.findAll();
		return user;
	}

	public Map<String, Object> updateUser(Long userId, UserDTO user)
	{
		 Map<String, Object> result = new HashMap<String, Object>();
	        Boolean isSuccess = false;
	        
            User usr = userRepository.findOne(userId);
            
            if (usr == null) {
                result.put("isSuccess", isSuccess);
                //result.put("message", messageService.getMessage(Message.NOT_EXIST));
                System.out.println("don't have user");
                return result;
            }
            
            usr.setEmail(user.getEmail());
            usr.setName(user.getName());
            isSuccess=true;
            
            userRepository.save(usr);

            
            result.put("isSuccess", isSuccess);
            System.out.println("Market updated sucessfully");

            return result;
	}
}
