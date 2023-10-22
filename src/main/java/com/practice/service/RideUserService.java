package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MUser;

@Service
@Transactional
public interface RideUserService {
	
	
	 public List<MUser> findRideMUser();
	 
	 public void updateRideMUser(String userId, String rideUser);
	 

}
