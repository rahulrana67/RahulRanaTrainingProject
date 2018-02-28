package com.oodles.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oodles.domain.Activity;

public interface AcitvityRepository extends JpaRepository<Activity, Serializable> 
{

	public Activity findByActivityId(Long activityId);
	
	
	
}
