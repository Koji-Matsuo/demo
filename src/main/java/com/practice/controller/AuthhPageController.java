package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.code.ContorollerCode;
import com.practice.entity.MUser;
import com.practice.input.MakeUserForm;
import com.practice.service.MakeUserService;

/**
 * 認証処理コントローラー。
 */
@Controller
public class AuthhPageController {

	@Autowired
	private MakeUserService service;
	
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
	
	/**
	 * ユーザー作成画面。
	 * @return
	 */
	@GetMapping(ContorollerCode.MAKE_USER)
	public String makeUser(
			Model model
			) {
		MakeUserForm form = new MakeUserForm();
		model.addAttribute("makeUserForm",form);
		return ContorollerCode.MAKE_USER_URL;
	}
	
	/**
	 * ユーザー登録。
	 * @param model 
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(ContorollerCode.MAKE_USER)
	public String entryMakeUser(
			Model model
			,@ModelAttribute @Validated MakeUserForm form
			,BindingResult bindingResult
			) {
		 // 入力チェック判定
        if (!bindingResult.hasErrors()){
        	//重複チェック
        	MUser user = service.findMUser(form.getUserId());
        	//登録処理
        	if (user == null) {
        		service.insertUser(form);
            	model.addAttribute("message","ユーザーが作成されました。");		
        	} else {
        		model.addAttribute("message", "ユーザーがすでに存在しています。");
        	}
        }
        model.addAttribute("makeUserForm",form);
        return ContorollerCode.MAKE_USER_URL;
	}
	
}
