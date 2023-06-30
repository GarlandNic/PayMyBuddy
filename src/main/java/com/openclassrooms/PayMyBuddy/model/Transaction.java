/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.time.LocalDate;

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
@Table(name = "transactions")
public class Transaction {
	
	@Id
	private String senderEmail;
	
	@Id
	private String recipientEmail;
	
	@Id
	private LocalDate time;
	
	private int value;
	
	private String description;

}
