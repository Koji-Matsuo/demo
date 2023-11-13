package com.practice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.entity.MUser;
import com.practice.mapper.RideUserMapper;

@Repository
public class RideUserRepositoryImpl implements RideUserRepository{	
      
   
    private final RideUserMapper mapper;    

    //コンストラクタインジェクション
    RideUserRepositoryImpl(RideUserMapper mapper) {
    	this.mapper = mapper;
    }
    /**
     * ユーザー検索.
     */
    public List<MUser> findRideMUser() {
    	return mapper.findRideMUser();
    }

   
}
