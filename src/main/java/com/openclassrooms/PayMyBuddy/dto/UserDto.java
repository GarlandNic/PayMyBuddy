package com.openclassrooms.PayMyBuddy.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private String email;
	
	private String nickname;
	
	private String password;
	
	private int balanceInCent=0;

}
