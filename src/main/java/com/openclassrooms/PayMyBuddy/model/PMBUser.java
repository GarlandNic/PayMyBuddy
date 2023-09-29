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
public class PMBUser {
	
	@Id
	private String email;
	
	private String password;
	
	private Long balance=0L;
	// sql integer unsigned : 0 - 4,294,967,295
	// java int : -2,147,483,648 à 2,147,483,647

}
