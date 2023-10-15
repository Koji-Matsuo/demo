package com.practice.entity;

import lombok.Data;

/**
 * m_user テーブルクラス。
 */
@Data
public class MUser {
	
	private String userId;
	
	private String userName;
	
	private String password;
	
	private String mailAddress;
	
	private String phoneNumber;
	
	private String roleCode;
	
	private String rideUser;
}
