/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Nicolas Garland
 *
 */
@Entity
@Data
@Table(name = "friends")
@IdClass(FriendID.class)
public class Friend {
	
	@Id
	private String userEmail;
	
	@Id
	private String friendEmail;
	
	private String nickname = friendEmail;

}
