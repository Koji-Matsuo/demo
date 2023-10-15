package com.practice.repository;

import org.springframework.stereotype.Repository;

import com.practice.entity.MUser;

@Repository
public interface MakeUserRepository {
	
    /**
     * ユーザー登録（USER）.
     * @param form
     */
    void insertMUser(MUser use);

}
