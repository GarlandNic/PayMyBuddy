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

/**
 * @author Nicolas Garland
 *
 */
@Entity
@Data
@Table(name = "users")
public class PMBUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usersId;
	
	private String email;
	
	private String nickname = email;
	
	private String password;
	
	private int balanceInCent=0;
	// sql integer unsigned : 0 - 4,294,967,295
	// java int : -2,147,483,648 à 2,147,483,647
	
	public void increaseAccount(int money) {
		if(money>0) this.balanceInCent += money;
	}
	public void decreaseAccount(int money) {
		if(money>0) this.balanceInCent -= money;
	}
	
	@OneToMany(cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY, 
			   mappedBy = "user")
	private List<Friend> friendsList = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, 
			   fetch = FetchType.LAZY, 
			   mappedBy = "buddy")
	private List<Friend> reverveFriendshipList = new ArrayList<>();

}
