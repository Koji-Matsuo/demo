package com.practice.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.entity.MUser;
import com.practice.mapper.LoginFormMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	private final LoginFormMapper mapper;
	//コンストラクタインジェクション
	UserDetailsServiceImpl(LoginFormMapper mapper){
		this.mapper = mapper;
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
		 MUser user = mapper.findMUser(username);
		if (user == null) {
            throw new UsernameNotFoundException("User " + username + "was not found in the database");
        }
        return User.withUsername(user.getUserId())
        		.roles(user.getRoleCode())
        		.password(user.getPassword())
        		.build();
    }
}
