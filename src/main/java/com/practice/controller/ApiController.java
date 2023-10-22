package com.practice.controller;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.code.RoleCode;
import com.practice.json.RoleJson;
import com.practice.session.SecuritySession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * 管理者権限コントローラー。
 */
@RestController
public class ApiController extends SecuritySession{

	
	
	@GetMapping("/api/role")
	public void getRole(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		
		RoleJson role = new RoleJson();
		role.setUserId(getUsername());
		role.setRoleCode(getRole());
		 try {
	        //JSONの出力
			 ObjectMapper mapper = new ObjectMapper();
			 String json = mapper.writeValueAsString(role);
	         response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
	
	}
	
	private String getRole() {
		// 権限情報を取得する。
		Collection<? extends GrantedAuthority> roles = getAuthorities();
		for (GrantedAuthority role : roles) {
			if (role.toString().equals(RoleCode.ROLE_ADMIN)) {
				return RoleCode.ADMIN;
			} else if (role.toString().equals(RoleCode.ROLE_STAFF)) {
				return RoleCode.STAFF;
			} else if(role.toString().equals(RoleCode.ROLE_USER)){
				return RoleCode.USER;
			}
        }
		//権限がない場合
		return "";
	}
	
	
}
