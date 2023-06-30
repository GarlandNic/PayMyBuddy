/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Nicolas Garland
 *
 */
@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	private String email;
	
	private String password;
	
	private int balance=0;

}
