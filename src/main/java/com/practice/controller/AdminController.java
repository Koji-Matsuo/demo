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
import com.practice.input.MakeAdminForm;
import com.practice.input.MakeUserForm;
import com.practice.service.MakeUserService;
import com.practice.session.SecuritySession;


/**
 * 管理者権限コントローラー。
 */
@Controller
public class AdminController extends SecuritySession{
	
	@Autowired
	private MakeUserService service;
	
	@GetMapping(ContorollerCode.ADMIN_MENU)
	public String admin() {
		return ContorollerCode.ADMIN_MENU_URL;
	}
	
	/**
	 * ユーザー作成画面。
	 * @return
	 */
	@GetMapping(ContorollerCode.MAKE_ADMIN)
	public String makeUser(
			Model model
			,MakeUserForm form
			) {
		model.addAttribute("makeAdminForm",form);
		return ContorollerCode.MAKE_ADMIN_URL;
	}
	
	/**
	 * ユーザー登録。
	 * @param model 
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(ContorollerCode.MAKE_ADMIN)
	public String entryMakeUser(
			Model model
			,@ModelAttribute @Validated MakeAdminForm form
			,BindingResult bindingResult
			) {
		 // 入力チェック判定
        if (!bindingResult.hasErrors()){
        	//登録処理
        	service.insertAdmin(form);
        }
        model.addAttribute("makeAdminForm",form);
        return ContorollerCode.MAKE_ADMIN_URL;
	}

}
