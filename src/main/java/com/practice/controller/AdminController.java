package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.code.ContorollerCode;
import com.practice.entity.MUser;
import com.practice.input.MakeAdminForm;
import com.practice.input.RideUserForm;
import com.practice.service.MakeUserService;
import com.practice.service.RideUserService;
import com.practice.session.SecuritySession;


/**
 * 管理者権限コントローラー。
 */
@Controller
public class AdminController extends SecuritySession{
	
	
	private final MakeUserService mkUserService;
	private final RideUserService rdUserService;
	//コンストラクタインジェクション
	AdminController(MakeUserService mkUserService, RideUserService rdUserService ){
		this.mkUserService = mkUserService;
		this.rdUserService = rdUserService;
	}
	
	/**
	 * メニュー画面。
	 * @return
	 */
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
			,MakeAdminForm form
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
			@ModelAttribute @Validated MakeAdminForm form
			,BindingResult bindingResult
			,Model model
			) {
		 // 入力チェック判定
        if (!bindingResult.hasErrors()){
        	//重複チェック
        	MUser user = mkUserService.findMUser(form.getUserId());
        	//登録処理
        	if (user == null) {
        		mkUserService.insertAdmin(form);
            	model.addAttribute("message","ユーザーが作成されました。");		
        	} else {
        		model.addAttribute("message", "ユーザーがすでに存在しています。");
        	}
        }
        model.addAttribute("makeAdminForm",form);
        return ContorollerCode.MAKE_ADMIN_URL;
	}
	
	/**
	 * ユーザー乗り込み画面初期表示。
	 * @return
	 */
	@GetMapping(ContorollerCode.RIDE_USER)
	public String rideUser(
			RideUserForm form
			,Model model
			) {
		form.setRideUserList(rdUserService.findRideMUser());
		model.addAttribute("rideUserForm",form);
		return ContorollerCode.RIDE_USER_URL;
	}

	@PostMapping(ContorollerCode.RIDE_USER)
	public String rideUserPost(
			RideUserForm form
			,Model model) {
		rdUserService.updateRideMUser(getUsername(), form.getUserId());
		return ContorollerCode.USER_MENU_URL;
	}
	
	
}
