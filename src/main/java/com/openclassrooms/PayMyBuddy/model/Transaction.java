/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Nicolas Garland
 *
 */
@Entity
@Data
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
//	private int friendshipId;
	
	private LocalDateTime transferTime;
	
	// value in cent
	private int sentValueInCent=0;
	
	// not a computed value because fee rate could change over time
	private int taxedFeeInCent=0;
	// sql integer unsigned : 0 - 4,294,967,295
	// java int : -2,147,483,648 à 2,147,483,647
	
	private String description;
	
//	private static final Long MAX_INT = 4294967295L;
	
	public int getReceivedValueInCent() {
		return (this.sentValueInCent - this.taxedFeeInCent);
	}
	
	@ManyToOne
	@JoinColumn(name = "friendship_id")
	private Friend friendship;

}
