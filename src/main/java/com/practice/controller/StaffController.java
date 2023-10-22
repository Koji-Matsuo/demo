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
import com.practice.input.MakeStaffForm;
import com.practice.input.MakeUserForm;
import com.practice.service.MakeUserService;
import com.practice.session.SecuritySession;

/**
 * スタッフ権限コントローラー。
 */
@Controller
public class StaffController extends SecuritySession{

	@Autowired
	private MakeUserService service;
	
	@GetMapping(ContorollerCode.STAFF_MENU)
	public String staff() {
		return ContorollerCode.STAFF_MENU_URL;
	}

	@GetMapping(ContorollerCode.SNGL_CLMN_PG)
	public String single_column_page() {
		return ContorollerCode.SNGL_CLMN_PG_URL;
	}
	
	
	/**
	 * ユーザー作成画面。
	 * @return
	 */
	@GetMapping(ContorollerCode.MAKE_STAFF)
	public String makeUser(
			Model model
			,MakeUserForm form
			) {
		model.addAttribute("makeStaffForm",form);
		return ContorollerCode.MAKE_STAFF_URL;
	}
	
	/**
	 * ユーザー登録。
	 * @param model 
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(ContorollerCode.MAKE_STAFF)
	public String entryMakeUser(
			Model model
			,@ModelAttribute @Validated MakeStaffForm form
			,BindingResult bindingResult
			) {
		 // 入力チェック判定
        if (!bindingResult.hasErrors()){
        	//重複チェック
        	MUser user = service.findMUser(form.getUserId());
        	//登録処理
        	if (user == null) {
        		service.insertStaff(form);
            	model.addAttribute("message","ユーザーが作成されました。");		
        	} else {
        		model.addAttribute("message", "ユーザーがすでに存在しています。");
        	}
        }
        model.addAttribute("makeStaffForm",form);
        return ContorollerCode.MAKE_STAFF_URL;
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
