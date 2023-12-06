package com.openclassrooms.PayMyBuddy.dto;

import com.openclassrooms.PayMyBuddy.model.PMBUser;

import lombok.Data;

@Data
public class UserDto {
	
	private String email;
	
	private String nickname;
	
	private String password;
	
	private int balanceInCent=0;
	
	public UserDto() {
	}
	
	/**
	 * Create UserDto from PMBUser (database)
	 * @param user
	 */
	public UserDto(PMBUser user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.password = user.getPassword();
		this.balanceInCent = user.getBalanceInCent();
	}

}
