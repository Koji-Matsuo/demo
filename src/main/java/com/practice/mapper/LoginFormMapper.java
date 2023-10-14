package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.practice.entity.MUser;

@Mapper
public interface LoginFormMapper {
	

	/**
     * ユーザー情報を取得する。
     */
    MUser findMUser(String userId);
    

}
