package com.practice.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.code.ContorollerCode;
import com.practice.code.RoleCode;
import com.practice.session.SecuritySession;


/**
 * 画面切り替えコントローラー。
 */
@Controller
public class SwitchController extends SecuritySession{

	private final UserController userCnt;
	private final StaffController stfCnt;
	private final AdminController adminCnt;
	
	//コンストラクタインジェクション
	SwitchController(UserController userCnt, StaffController stfCnt, AdminController adminCnt){
		this.userCnt = userCnt;
		this.stfCnt = stfCnt;
		this.adminCnt = adminCnt;
	}
	
	@GetMapping(ContorollerCode.SWITH)
	public String swtch(Model model) {
		// 権限情報を取得する。
		Collection<? extends GrantedAuthority> roles = getAuthorities();
        boolean admin = false;
        boolean user = false;
        boolean staff = false;
		for (GrantedAuthority role : roles) {
			admin = role.toString().equals(RoleCode.ROLE_ADMIN);
			user = role.toString().equals(RoleCode.ROLE_USER);
			staff = role.toString().equals(RoleCode.ROLE_STAFF);
        }
		//権限によって遷移先を決定する。
		if (admin) {
			return adminCnt.admin();
		} else if (staff){
			return stfCnt.staff();
		} else if (user) {
			return userCnt.user(model);
		}
		//権限がない場合はアクセス不可へ
		return ContorollerCode.ACCESS_DISABLE_URL;
	}
		
}
