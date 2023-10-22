package com.practice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.entity.MUser;

@Repository
public interface RideUserRepository {
	
    /**
     * ユーザー検索.
     */
    List<MUser> findRideMUser();

}
