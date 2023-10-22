package com.practice.code;

/**
 * コントローラーコード。
 */
public class ContorollerCode {
	
		
	/**
	 * 認証コントローラー。
	 */
	/* ログイン画面。*/
	public static final String AUTH = "/auth/auth";
	public static final String AUTH_ERROR = "/auth/auth?error";
	/* ログイン画面URL。*/
	public static final String AUTH_URL = "html/auth/loginForm";
	/** ログアウト画面。*/
	public static final String LOGOUT = "/auth/logout";
	/** ログアウト画面URL。*/
	public static final String LOGOUT_URL = "html/auth/loginForm";
	/** アクセス不可。*/
	public static final String ACCESS_DISABLE = "/auth/display-access-denied";
	/** アクセス不可 URL。*/
	public static final String ACCESS_DISABLE_URL = "html/auth/accessDenial";
	/** ユーザー作成画面.*/
	public static final String MAKE_USER = "/auth/make_user";
	/** ユーザー作成画面URL.*/
	public static final String MAKE_USER_URL = "html/auth/makeUser";
	
	/**
	 * ユーザー切り替え。
	 */
	/** ユーザー切り替えコントローラー.*/
	public static final String SWITH = "/switch";

	
	/**
	 * 管理者コントローラー。
	 */
	/** 管理者メニューコントローラー.*/
	public static final String ADMIN_MENU = "/admin/admin";
	/** 管理者メニューURL.*/
	public static final String ADMIN_MENU_URL = "html/admin/adminMenu";
	/** ユーザー作成画面.*/
	public static final String MAKE_ADMIN = "/admin/make_admin";
	/** ユーザー作成画面URL.*/
	public static final String MAKE_ADMIN_URL = "html/admin/makeAdmin";
	/** ユーザー乗込画面.*/
	public static final String RIDE_USER = "/admin/ride_user";
	/** ユーザー乗込画面URL.*/
	public static final String RIDE_USER_URL = "html/admin/rideUser";
	
	

	/**
	 * スタッフコントローラー。
	 */
	/** スタッフメニューコントローラー.*/
	public static final String STAFF_MENU = "/staff/staff";
	/**スタッフメニューURL.*/
	public static final String STAFF_MENU_URL = "html/staff/staffMenu";
	/** ユーザー作成画面.*/
	public static final String MAKE_STAFF = "/staff/make_staff";
	/** ユーザー作成画面URL.*/
	public static final String MAKE_STAFF_URL = "html/staff/makeStaff";
	/** 日本画面.*/
	public static final String JAPAN = "/staff/japan";
	/** 日本画面URL.*/
	public static final String JAPAN_URL = "html/staff/japan";
	/** シングルカラム画面.*/
	public static final String SNGL_CLMN_PG = "/staff/single_column_page";
	/** シングルカラム画面URL.*/
	public static final String SNGL_CLMN_PG_URL = "html/staff/single_column_page";
	/** ２カラム画面.*/
	public static final String TW_CLMN_PG = "/staff/two_column_page";
	/** ２カラム画面　URL.*/
	public static final String TW_CLMN_PG_URL = "html/staff/two_column_page";
	/** アメリカ画面.*/
	public static final String USA = "/staff/usa";
	/** アメリカ画面URL.*/
	public static final String USA_URL = "html/staff/usa";

	
	/**
	 * ユーザーコントローラー。
	 */
	/** ユーザーメニュー画面.*/
	public static final String USER_MENU = "/user/user";
	/** ユーザーメニュー画面URL.*/
	public static final String USER_MENU_URL = "html/user/userMenu";
	/** 問い合わせ画面.*/
	public static final String CONTACT = "/user/contact";
	/** 問い合わせ画面URL.*/
	public static final String CONTACT_URL = "html/user/contact";
	/** 問い合わせ画面リダイレクトURL.*/
	public static final String REDIRECT_CONTACT_URL = "redirect:./../user/contact#contact";	
	/** JDBC問い合わせ画面.*/
	public static final String JDBC_CONTACT = "/user/contactJdbc";
	/** JDBC問い合わせ画面URL.*/
	public static final String JDBC_CONTACT_URL = "html/user/contactJdbc";
	/** JDBC問い合わせ画面リダイレクトURL.*/
	public static final String JDBC_REDIRECT_CONTACT_URL = "redirect:./../user/contactJdbc#contact";
	
	
}
