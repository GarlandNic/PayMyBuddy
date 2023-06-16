/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
	
	private String senderEmail;
	
	private String recipientEmail;
	
	private LocalDate time;
	
	private int value;
	
	private String description;

}
