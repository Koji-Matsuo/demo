package com.practice.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MakeUserForm {
	
	
	/** ユーザーID.*/
	@NotEmpty(message = "ユーザーIDを選択してください。")
	@Size(min= 1,max=8, message="8文字以内で入力してください。")
	private String userId;
	
	/** ユーザー名.*/
	@NotEmpty(message = "ユーザー名を選択してください。")
	@Size(min= 1,max=100, message="100文字以内で入力してください。")
	private String userName; 
	
	/** パスワード.*/
	@NotEmpty(message = "パスワードを選択してください。")
	@Size(min= 1,max=200, message="200文字以内で入力してください。")
	private String password;
	
	/** メールアドレス.*/
	@NotEmpty(message = "メールアドレスを選択してください。")
	@Size(min= 1,max=500, message="500文字以内で入力してください。")
	private String mailAddress;
	
	/** 電話番号.*/
	@NotEmpty(message = "電話番号を選択してください。")
	@Size(min= 1,max=15, message="15文字以内で入力してください。")
	private String phoneNumber;
	
}
