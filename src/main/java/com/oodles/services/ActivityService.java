package com.oodles.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oodles.dto.RoleActivityDTO;
import com.oodles.repository.RoleRepository;
import com.oodles.repository.AcitvityRepository;
import com.oodles.services.ActivityService;
import com.oodles.domain.Activity;
import com.oodles.domain.Role;
//import com.oodles.domain.User;

@Service
public class ActivityService 
{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AcitvityRepository activityRepository;
	
	Logger LOGGER=LoggerFactory.getLogger(ActivityService.class);
	
	
	public Map<String, Object> assignActivities(RoleActivityDTO dto) {

        Map<String, Object> result = new HashMap<String, Object>();
        List<Activity> activities = new ArrayList<>();
        Boolean isSuccess = false;
        Long roleId = dto.getRoleId();
        Long [] dtoActivities = dto.getActivities();
        if (roleId != null && dtoActivities != null){
            Role role = roleRepository.findById(roleId);

            try{
                for(Long activityId : dtoActivities){
//                    Activity activity =  activityRepository.findByRoleListAndActivityId(role, acId);
                    Activity activity = activityRepository.findByActivityId(activityId);

                    if(activity == null){
                        LOGGER.info("No such activity found");
                        result.put("error",activityId);
                       // result.put("message", messageService.getMessage(Message.ERROR));
                        result.put("isSuccess", isSuccess);
                        return result;
                    }
                    activities.add(activity);
                }
                role.setActivities(activities);
                roleRepository.save(role);
                LOGGER.info("activities assigned successfully");
                isSuccess = true;
               // result.put("message", messageService.getMessage(Message.SUCCESS));
            } catch(Exception e){
                LOGGER.warn(e.getMessage());
               // result.put("message", messageService.getMessage(Message.INTERNAL_SERVER_ERROR));
            }
        }else{
            LOGGER.info("Invalid data");
           // result.put("message", messageService.getMessage(Message.INVALID_INPUTS));
        }
        result.put("isSuccess", isSuccess);
        return result;
    }	
	
	public Map<String,Object> addActivity(Activity activity)
	{
		
			Map<String, Object> result=new HashMap<String, Object>();
			Boolean isSuccess=false;
			
			Activity isExist=activityRepository.findByActivityId(activity.getActivityId());
			if(isExist!=null)
			{
				isSuccess=false;
				result.put("isSucces", isSuccess);
			}
			activityRepository.save(activity);
        	result.put("isSuccess", isSuccess);
        	result.put("data", activity);
        	return result;
	}
	
}
