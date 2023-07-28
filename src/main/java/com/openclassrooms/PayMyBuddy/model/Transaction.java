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
	private LocalDate transferTime;
	
	// value in cents
	private int value;
	
	// not a computed value because fee rate could change over time
	private int fee;
	
	private String description;

}
