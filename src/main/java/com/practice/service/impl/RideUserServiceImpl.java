package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MUser;
import com.practice.mapper.RideUserMapper;
import com.practice.service.RideUserService;

@Service
@Transactional
public class RideUserServiceImpl implements RideUserService{

	RideUserServiceImpl(){
	}
	
	@Autowired private RideUserMapper mapper;
 
	
	 public List<MUser> findRideMUser() {		
		return mapper.findRideMUser();
	}
	
	 
	public void updateRideMUser(String userId, String rideUser) {		
		mapper.updateRideMUser(userId, rideUser);
	}


 }
