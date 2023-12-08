/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PMBuser")
public class PMBUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String email;
	
	private String nickname = email;
	
	private String password;
	
	private int balanceInCent=0;
	
	/** 
	 * the balance should be modified only from increase and decrease Account ; check if parameter is positive
	 * @param money
	 */
	public void increaseAccount(int money) {
		if(money>0) this.balanceInCent += money;
	}
	/**
	*@see #increaseAccount(int)
	*/
	public void decreaseAccount(int money) {
		if(money>0) this.balanceInCent -= money;
	}
	/**
	*@see #increaseAccount(int)
	*/
	public void setBalanceInCent(int money) {
	}
	
	@OneToMany(cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY, 
			   mappedBy = "user")
	private List<Friend> friendList = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, 
			   fetch = FetchType.LAZY, 
			   mappedBy = "buddy")
	private List<Friend> reverseFriendshipList = new ArrayList<>();

}
