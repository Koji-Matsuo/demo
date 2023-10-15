package com.practice.input;

import java.util.List;

import com.practice.entity.MDictionary;
import com.practice.entity.TContact;
import com.practice.entity.WContact;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * contact.html フォーム。
 */
@Data
public class ContactForm {
		
	/** 連絡種別.*/
	@NotEmpty(message = "連絡種別を選択してください。")
	private String contactType;
		
	/** 連絡方法.*/
	@NotEmpty(message = "連絡方法を選択してください。")
	private String howtoContact;
	
	/** 連絡内容.*/
	@NotBlank(message = "連絡内容を入力してください。")
	private String contactMessage;
		
	/**問い合わせリスト.*/
	private List<TContact> contactList;
	
	/**問い合わせリスト.*/
	private List<WContact> wContactList;
	
	
	/**　連絡種別リスト.*/
	List<MDictionary> contactTypeList;

	/**　ご希望の連絡方法リスト.*/
	List<MDictionary> howToContactList;

}
