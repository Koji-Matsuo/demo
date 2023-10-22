package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.practice.entity.MUser;

@Mapper
public interface MakeUserMapper {
	

	/**
     * ユーザーを作成する。
     */
    void insertMUser(MUser user);
    

    /**
     * ユーザーを検索する。
     */
    MUser findMUser(String userId);
    
}
