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
	
	static private double FEE_RATE = 0.005;
	
	@Id
	private String senderEmail;
	
	@Id
	private String recipientEmail;
	
	@Id
	private LocalDate transferTime;
	
	// value in cents
	private int value;
	
	private String description;
	
	public int getFee() {
		return (int) Math.floor(((double) this.value)*FEE_RATE);
	}
	
	public int getDebit() {
		return (this.value + this.getFee());
	}
	
	public int getCredit() {
		return this.value;
	}

}
