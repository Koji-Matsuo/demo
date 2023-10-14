package com.practice.entity;

import lombok.Data;

/**
 * t_contact テーブルクラス。
 */
@Data
public class TContact{
	
	/* コンタクトID。*/
	private String contactId;
	
	/* ユーザーID.*/
	private String userId;
	
	/* ユーザー名.*/
	private String userName;
	
	/* メールアドレス.*/
	private String mailAddress;
	
	/* 連絡種別.*/
	private String contactType;
	
	/* 電話番号.*/
	private String phoneNumber;
	
	/* 連絡方法.*/
	private String howtoContact;
	
	/* 連絡内容.*/
	private String contactMessage;
	
	/* 管理者対応内容.*/
	private String adminRecovery;
	
	/**　問い合わせ日付.*/
	private String contactDate;
	
}
