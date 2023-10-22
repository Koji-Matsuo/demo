package com.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.code.RoleCode;
import com.practice.config.SecurityConfig;
import com.practice.entity.MUser;
import com.practice.input.MakeAdminForm;
import com.practice.input.MakeStaffForm;
import com.practice.input.MakeUserForm;
import com.practice.mapper.MakeUserMapper;
import com.practice.service.MakeUserService;

@Service
@Transactional
public class MakeUserServiceImpl implements MakeUserService{

	MakeUserServiceImpl(){
	}
	
	@Autowired private MakeUserMapper mapper;
 
    @Autowired
    private SecurityConfig security;

    
    /**
     * ユーザー登録（ADMIN）.
     * @param form
     */
    public void insertUser(MakeUserForm form) {
    	mapper.insertMUser(setMUser(form, RoleCode.USER));
    }
    
    /**
     * ユーザー登録（STAFF）.
     * @param form
     */
    public void insertStaff(MakeStaffForm form) {
    	mapper.insertMUser(setMUser(form, RoleCode.STAFF));
    }
    
    /**
     * ユーザー登録（USER）.
     * @param form
     */
    public void insertAdmin(MakeAdminForm form) {
    	mapper.insertMUser(setMUser(form));
    }
    
    
    /**
     * ユーザーを検索する。
     * @param userId
     * @return
     */
    public MUser findMUser(String userId) {
    	return mapper.findMUser(userId);
    }
    
    /**
     * 暗号化する。
     * @param pwd
     * @return
     */
    public String createEndocedPwd(String pwd) {
        String encodedPwd = security.passwordEncoder().encode(pwd).trim();
        return encodedPwd;
    }
    
    /**
     * エンティティにパラメータを設定する(USER)。
     * @param form
     * @param role
     * @return
     */
    private MUser setMUser(MakeUserForm form, String role) {
    	String password = createEndocedPwd(form.getPassword());
        MUser user = new MUser();
        user.setUserId(form.getUserId());
        user.setUserName(form.getUserName());        
        user.setMailAddress(form.getMailAddress());
        user.setPassword(password);
        user.setPhoneNumber(form.getPhoneNumber());
        user.setRoleCode(role);
    	return user;
    }
    
    /**
     * エンティティにパラメータを設定する(STAFF)。
     * @param form
     * @param role
     * @return
     */
    private MUser setMUser(MakeStaffForm form, String role) {
    	String password = createEndocedPwd(form.getPassword());
        MUser user = new MUser();
        user.setUserId(form.getUserId());
        user.setUserName(form.getUserName());        
        user.setMailAddress(form.getMailAddress());
        user.setPassword(password);
        user.setPhoneNumber(form.getPhoneNumber());
        user.setRoleCode(role);
    	return user;
    }
    
    /**
     * エンティティにパラメータを設定する(ADMIN)。
     * @param form
     * @param role
     * @return
     */
    private MUser setMUser(MakeAdminForm form) {
    	String password = createEndocedPwd(form.getPassword());
        MUser user = new MUser();
        user.setUserId(form.getUserId());
        user.setUserName(form.getUserName());        
        user.setMailAddress(form.getMailAddress());
        user.setPassword(password);
        user.setPhoneNumber(form.getPhoneNumber());
        user.setRoleCode(form.getRoleCode());
    	return user;
    }
    
 }
