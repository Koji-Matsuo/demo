package com.practice.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * contact.html フォーム。
 */
@Data
public class RoleJson {
		
	 @JsonProperty("userId")
	 private String userId;
	 
	 @JsonProperty("roleCode")
	 private String roleCode;
	 

}
