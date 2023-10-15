package com.practice.input;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MakeAdminForm {
	
	/** ユーザーID.*/
	@NotEmpty(message = "ユーザーIDを選択してください。")
	private String userId;
	
	/** ユーザー名.*/
	@NotEmpty(message = "ユーザー名を選択してください。")
	private String userName; 
	
	/** パスワード.*/
	@NotEmpty(message = "パスワードを選択してください。")
	private String password;
	
	/** メールアドレス.*/
	@NotEmpty(message = "メールアドレスを選択してください。")
	private String mailAddress;
	
	/** 電話番号.*/
	@NotEmpty(message = "電話番号を選択してください。")
	private String phoneNumber;

}
