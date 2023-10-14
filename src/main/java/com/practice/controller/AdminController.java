package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.code.ContorollerCode;
import com.practice.session.SecuritySession;


/**
 * 管理者権限コントローラー。
 */
@Controller
public class AdminController extends SecuritySession{
	
    
	@GetMapping(ContorollerCode.ADMIN_MENU)
	public String admin() {
		return ContorollerCode.ADMIN_MENU_URL;
	}

}
