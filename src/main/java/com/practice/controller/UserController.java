package com.practice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.code.ContorollerCode;
import com.practice.code.RoleCode;
import com.practice.entity.MUser;
import com.practice.input.ContactForm;
import com.practice.service.ContactMapperService;
import com.practice.service.ContactService;
import com.practice.session.SecuritySession;

/**
 * ユーザー権限コントローラー。
 */
@Controller
public class UserController extends SecuritySession{
	
	@Autowired private ContactMapperService mapperService;
	@Autowired private ContactService service;
	
	
	/**
	 * 管理者権限で乗り込んでいるか確認する。
	 * @return
	 */
	private boolean isAdmin() {
		// 権限情報を取得する。
		Collection<? extends GrantedAuthority> roles = getAuthorities();
        for (GrantedAuthority role : roles) {
			return role.toString().equals(RoleCode.ROLE_ADMIN);
			
        }
		return false;
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(ContorollerCode.USER_MENU)
	public String user(Model model) {
		model.addAttribute("isAdmin",isAdmin());
		return ContorollerCode.USER_MENU_URL;
	}
	
	/* -----------------------ここからMapper---------------------------------------*/
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(ContorollerCode.CONTACT)
	public String contactMapper(Model model) {
		model.addAttribute("contactForm", initFormMapper());
		return ContorollerCode.CONTACT_URL;
	}
	/**
	 * 
	 * @param model
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(ContorollerCode.CONTACT)
	public String entryMapper( 
			Model model
			,@ModelAttribute @Validated ContactForm form
			,BindingResult bindingResult) {
		 // 入力チェック判定
        if (!bindingResult.hasErrors()){
        	//登録処理
        	mapperService.insertTContact(form);
        	return ContorollerCode.REDIRECT_CONTACT_URL;
        }
        model.addAttribute("contactForm",setWindowMapperLists(form));
        return ContorollerCode.CONTACT_URL;
	}	
	/**
	 * ContactForm の初期化.
	 * @return　 contact.html フォーム
	 */
	private ContactForm initFormMapper() {
		ContactForm form = new ContactForm();
		return setWindowMapperLists(form);
	}
		
	/**
	 * contact.html の一覧データを取得する。
	 * @param form ContactForm の登録用フォーム
	 * @return ContactForm の登録用フォーム
	 */
	private ContactForm setWindowMapperLists(ContactForm form) {
		//ToDo ユーザー情報からユーザーIDを取得する
		form.setWContactList(mapperService.findContactListJoin());
		form.setContactTypeList(mapperService.findContactTypeList());
		form.setHowToContactList(mapperService.findHowToContactList());
		return form;
	}
	
	
	/* -----------------------ここからJDBC---------------------------------------*/
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(ContorollerCode.JDBC_CONTACT)
	public String contact(Model model) {
		model.addAttribute("contactForm", initForm());
		return "html/user/contactJdbc.html";
	}
	
	/**
	 * 
	 * @param model
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(ContorollerCode.JDBC_CONTACT)
	public String entry( 
			Model model
			,@ModelAttribute @Validated ContactForm form
			,BindingResult bindingResult) {
		 // 入力チェック判定
        if (!bindingResult.hasErrors()){
        	//登録処理
        	service.insertTContact(form);
        	return ContorollerCode.JDBC_REDIRECT_CONTACT_URL;
        }
        model.addAttribute("contactForm",setWindowLists(form));
        return ContorollerCode.JDBC_CONTACT_URL;
	}
	
	/**
	 * ContactForm の初期化.
	 * @return　 contact.html フォーム
	 */
	private ContactForm initForm() {
		ContactForm form = new ContactForm();
		return setWindowLists(form);
	}
		
	/**
	 * contact.html の一覧データを取得する。
	 * @param form ContactForm の登録用フォーム
	 * @return ContactForm の登録用フォーム
	 */
	private ContactForm setWindowLists(ContactForm form) {
		//ToDo ユーザー情報からユーザーIDを取得する
		MUser user = service.findMUser("1");	
		form.setContactList(service.findContactList(user.getUserId()));
		form.setContactTypeList(service.findContactTypeList());
		form.setHowToContactList(service.findHowToContactList());
		return form;
	}
}
	
