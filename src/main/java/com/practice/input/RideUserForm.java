package com.practice.input;

import java.util.List;

import com.practice.entity.MUser;

import lombok.Data;

/**
 * rideUser.html フォーム。
 */
@Data
public class RideUserForm {
		
	/** ユーザーID。*/
	private String userId;
	
	/**問い合わせリスト.*/
	private List<MUser> rideUserList;
	
}
