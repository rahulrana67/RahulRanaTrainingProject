package com.oodles.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oodles.dto.UserEditDTO;
import com.oodles.exception.UserAlreadyExistsException;
import com.oodles.domain.UserAddress;
import com.oodles.util.ResponseHandler;
import com.oodles.constants.Message;
import com.oodles.domain.User;
import com.oodles.dto.UserDTO;
import com.oodles.repository.UserRepository;
import com.oodles.repository.UserAddressRepository;


@Service
public class UserService 
{
	Logger LOGGER=LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserAddressRepository userAddressRepository;
	
	@Autowired
	MessageService messageService;
	
	public Map<String,Object> saveUser(User user)
	{
		String user1 = user.getEmail();
		System.out.println("----------------------------------------"+user1);
		Map<String, Object> result = new HashMap<String, Object>();
		User user2=userRepository.findUserByEmail(user.getEmail());
		if(user2!=null)
		{
			try
			{
				throw new UserAlreadyExistsException("User already Exist");
			}
			
			catch(UserAlreadyExistsException e)
			{
			LOGGER.info("Exception occured");
			result.put("isSucces",false);
			result.put("message", messageService.getMessage(Message.ALREADY_EXIST));//"User +++++++Already exist"
			return result;
			}
			
		}
		else 
		{
        Boolean isSuccess = false;
        User usr=new User();
        usr.setEmail(user.getEmail());
        usr.setId(user.getId());
        usr.setName(user.getName());
       // usr.setDob(user.getDob());
        usr.setGender(user.getGender());
        usr.setPhoneNumber(user.getPhoneNumber());
        usr.setPassword(user.getPassword());
        userRepository.save(usr);
        
       
        	result.put("isSuccess", isSuccess);
        	result.put("data", usr);
        	result.put("message", messageService.getMessage(Message.SUCCESS));
        	return result;
		}
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
                result.put("message", messageService.getMessage(Message.NOT_EXIST));
                System.out.println("don't have user");
                return result;
            }
            
            usr.setEmail(user.getEmail());
            usr.setName(user.getName());
            isSuccess=true;
            
            userRepository.save(usr);

            
            result.put("isSuccess", isSuccess);
            result.put("message", messageService.getMessage(Message.SUCCESS));
            System.out.println("User updated sucessfully");

            return result;
	}
	
	
	public ResponseEntity<Object> editUserProfile(UserEditDTO userEditDTO) {
		Boolean isSuccess = true;
		String message = "Data is saved seccussfully";
		User user = userRepository.findOne(userEditDTO.getId());
		if (user == null) {
			isSuccess = false;
			message = "Please enter valid id";
			return ResponseHandler.generateResponse(HttpStatus.OK, isSuccess, message, userEditDTO);
		}
		
		user.setName(userEditDTO.getName());
		user.setPhoneNumber(userEditDTO.getPhoneNumber());
		//user.setDob(userEditDTO.getDob());
		user.setGender(userEditDTO.getGender());
		
		UserAddress userAddress = user.getUserAddress();
		if (userAddress == null) {
			userAddress = new UserAddress();
		}
		userAddress.setCity(userEditDTO.getCity());
		userAddress.setPlace(userEditDTO.getPlace());
		userAddress.setState(userEditDTO.getState());
		userAddressRepository.save(userAddress);
		user.setUserAddress(userAddress);
		//user.setIsProfileCompleted(true);
		User savedUser = userRepository.save(user);
		if (savedUser == null) {
			isSuccess = false;
			message = "Data is not saved";
		}
		return ResponseHandler.generateResponse(HttpStatus.OK, isSuccess, message, savedUser);
	}
	
}
