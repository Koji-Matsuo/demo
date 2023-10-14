package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.code.ContorollerCode;
import com.practice.session.SecuritySession;

/**
 * スタッフ権限コントローラー。
 */
@Controller
public class StaffController extends SecuritySession{

	
	@GetMapping(ContorollerCode.STAFF_MENU)
	public String staff() {
		return ContorollerCode.STAFF_MENU_URL;
	}

	@GetMapping(ContorollerCode.SNGL_CLMN_PG)
	public String single_column_page() {
		return ContorollerCode.SNGL_CLMN_PG_URL;
	}
	
	@GetMapping(ContorollerCode.TW_CLMN_PG)
	public String two_column_page() {
		return ContorollerCode.TW_CLMN_PG_URL;
	}
	
	
	@GetMapping(ContorollerCode.JAPAN)
	public String japan() {
		return ContorollerCode.JAPAN_URL;
	}
	
	@GetMapping(ContorollerCode.USA)
	public String usa() {
		return ContorollerCode.USA_URL;
	}
	
}
