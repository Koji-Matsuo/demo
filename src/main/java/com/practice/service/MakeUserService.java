package com.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.input.MakeAdminForm;
import com.practice.input.MakeStaffForm;
import com.practice.input.MakeUserForm;

@Service
@Transactional
public interface MakeUserService {
	
	
	 
	 String createEndocedPwd(String pwd);
	 
    /**
     * ユーザー登録（ADMIN）.
     * @param form
     */
    void insertUser(MakeUserForm form);
    
    /**
     * ユーザー登録（STAFF）.
     * @param form
     */
    void insertStaff(MakeStaffForm form);
    
    /**
     * ユーザー登録（USER）.
     * @param form
     */
    void insertAdmin(MakeAdminForm form);

}
