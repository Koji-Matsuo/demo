package com.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.practice.entity.MUser;

@Mapper
public interface RideUserMapper {
	

	
    /**
     * ユーザーを検索する。
     */
    List<MUser> findRideMUser();
    
    void updateRideMUser(@Param("userId") String userId, @Param("rideUser") String rideUser);
    
}
