package com.practice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.entity.MUser;
import com.practice.mapper.RideUserMapper;

@Repository
public class RideUserRepositoryImpl implements RideUserRepository{	
      
   
    @Autowired private RideUserMapper mapper;    
    
    /**
     * ユーザー検索.
     */
    public List<MUser> findRideMUser() {
    	return mapper.findRideMUser();
    }

   
}
