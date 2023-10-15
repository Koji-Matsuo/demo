package com.practice.code;

/**
 * コントローラーコード。
 */
public class ContorollerCode {
	
		
	//AuthhPageController
	/* ログイン画面。*/
	public static final String AUTH = "/auth";
	public static final String AUTH_ERROR = "/auth?error";
	
	/* ログイン画面URL。*/
	public static final String AUTH_URL = "html/auth/loginForm";
	/** ログアウト画面。*/
	public static final String LOGOUT = "/logout";
	/** ログアウト画面URL。*/
	public static final String LOGOUT_URL = "html/auth/loginForm";
	/** アクセス不可。*/
	public static final String ACCESS_DISABLE = "/display-access-denied";
	/** アクセス不可 URL。*/
	public static final String ACCESS_DISABLE_URL = "html/auth/accessDenial";
	/** ユーザー作成画面.*/
	public static final String MAKE_USER = "/make_user";
	/** ユーザー作成画面URL.*/
	public static final String MAKE_USER_URL = "html/auth/makeUser";
	
	//SwitchController
	/** ユーザー切り替えコントローラー.*/
	public static final String SWITH = "/switch";

	
	//AdminController
	/** 管理者メニューコントローラー.*/
	public static final String ADMIN_MENU = "/admin";
	/** 管理者メニューURL.*/
	public static final String ADMIN_MENU_URL = "html/admin/adminMenu";
	/** ユーザー作成画面.*/
	public static final String MAKE_ADMIN = "/make_admin";
	/** ユーザー作成画面URL.*/
	public static final String MAKE_ADMIN_URL = "html/admin/makeAdmin";
	

	//StaffController
	/** スタッフメニューコントローラー.*/
	public static final String STAFF_MENU = "/staff";
	/**スタッフメニューURL.*/
	public static final String STAFF_MENU_URL = "html/staff/staffMenu";
	/** ユーザー作成画面.*/
	public static final String MAKE_STAFF = "/make_staff";
	/** ユーザー作成画面URL.*/
	public static final String MAKE_STAFF_URL = "html/staff/makeStaff";
	
	
	public static final String JAPAN = "/japan";
	public static final String JAPAN_URL = "html/staff/japan";
	
	public static final String SNGL_CLMN_PG = "/single_column_page";
	public static final String SNGL_CLMN_PG_URL = "html/staff/single_column_page";
	
	public static final String TW_CLMN_PG = "/two_column_page";
	public static final String TW_CLMN_PG_URL = "html/staff/two_column_page";
	
	public static final String USA = "/usa";
	public static final String USA_URL = "html/staff/usa";

	
	//UserController
	public static final String USER_MENU = "/user";
	public static final String USER_MENU_URL = "html/user/userMenu";
	
	/** 問い合わせ画面.*/
	public static final String CONTACT = "/contact";
	/** 問い合わせ画面URL.*/
	public static final String CONTACT_URL = "html/user/contact";
	/** 問い合わせ画面リダイレクトURL.*/
	public static final String REDIRECT_CONTACT_URL = "redirect:contact#contact";	
	/** JDBC問い合わせ画面.*/
	public static final String JDBC_CONTACT = "/contactJdbc";
	/** JDBC問い合わせ画面URL.*/
	public static final String JDBC_CONTACT_URL = "html/user/contactJdbc";
	/** JDBC問い合わせ画面リダイレクトURL.*/
	public static final String JDBC_REDIRECT_CONTACT_URL = "redirect:contactJdbc#contact";
	
	
}
