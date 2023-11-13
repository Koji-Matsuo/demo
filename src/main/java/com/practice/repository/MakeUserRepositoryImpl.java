package com.practice.repository;

import org.springframework.stereotype.Repository;

import com.practice.entity.MUser;
import com.practice.mapper.MakeUserMapper;

@Repository
public class MakeUserRepositoryImpl implements MakeUserRepository{	
      
   
    private final MakeUserMapper mapper;    
    
    //コンストラクタインジェクション
    MakeUserRepositoryImpl(MakeUserMapper mapper){
    	this.mapper = mapper;
    }
    
    /**
     * ユーザー登録（USER）.
     * @param form
     */
    public void insertMUser(MUser user) {
    	mapper.insertMUser(user);
    }

   
}
