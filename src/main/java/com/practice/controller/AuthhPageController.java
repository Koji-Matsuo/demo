package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.code.ContorollerCode;

/**
 * 認証処理コントローラー。
 */
@Controller
public class AuthhPageController {

	
	/**
	 * ログイン画面。
	 * @param model
	 * @return
	 */
	@GetMapping(ContorollerCode.AUTH)
	public String login() {
		return ContorollerCode.AUTH_URL;
	}

	/**
	 * ログアウト画面。
	 * @param model
	 * @return
	 */
	@GetMapping(ContorollerCode.LOGOUT)
	public String logout() {
		return ContorollerCode.LOGOUT_URL;
	}
	
	/**
	 * ログイン失敗。
	 * @param model
	 * @return
	 */
	@GetMapping(value = ContorollerCode.AUTH, params = "error")
	public String loginFail(Model model) {
		model.addAttribute("failureMessage", "ログインに失敗しました");
		return ContorollerCode.AUTH_URL;
	}
	
	/**
	 * アクセス不可。
	 * @return
	 */
	@GetMapping(ContorollerCode.ACCESS_DISABLE)
	public String accessDenined() {
		return ContorollerCode.ACCESS_DISABLE_URL;
	}
	
}
