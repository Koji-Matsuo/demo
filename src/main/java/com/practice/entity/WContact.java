package com.practice.entity;

import lombok.Data;

/**
 * contact.html 明細データ。
 */
@Data
public class WContact{
	

	
	/* ユーザー名.*/
	private String userName;
	
	/* メールアドレス.*/
	private String mailAddress;
		
	/* 電話番号.*/
	private String phoneNumber;
		
	/* 連絡内容.*/
	private String contactMessage;
	
	/* 管理者対応内容.*/
	private String adminRecovery;
	
	/**　問い合わせ日付.*/
	private String contactDate;
	
	/* 連絡方法.*/
	private String howtoContactNm;
	
	/* 連絡種別.*/
	private String contactTypeNm;
		
}
