package com.oodles.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oodles.dto.RoleActivityDTO;
import com.oodles.mapping.URLMapping;
import com.oodles.domain.Activity;
import com.oodles.util.ResponseHandler;
import com.oodles.services.ActivityService;;

@RestController
public class ActivityController 
{
	@Autowired
	ActivityService activityService;
	
	
    @RequestMapping(value = URLMapping.ASSIGN_ACTIVITIES, method = RequestMethod.PUT)
    public ResponseEntity<Object> assignActivities(@RequestBody RoleActivityDTO dto) {
        Map<String, Object> result = null;
        try {
            result = activityService.assignActivities(dto);
            if(result.get("isSuccess").equals(true)){
                return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get("message").toString(), result);
            }
            else
                return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get("message").toString(), result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
        }
    }
	
	
    @RequestMapping(value = URLMapping.ADD_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<Object> addActivities(@RequestBody Activity activity) 
    {
    	 Map<String, Object> result = null;
         try {
             result = activityService.addActivity(activity);
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
