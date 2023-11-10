/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.Column;
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
@Table(name = "transactions")
@IdClass(TransactionID.class)
public class Transaction {
	
	private final static Logger logger = LogManager.getLogger("Transaction");

	@Id
	private String senderEmail;
	
	@Id
	private String recipientEmail;
	
	@Id
	private LocalDateTime transferTime;
	
	// value in cents
	@Column(name="value")
	private int sendValue=0;
	
	// not a computed value because fee rate could change over time
	private int fee=0;
	// sql integer unsigned : 0 - 4,294,967,295
	// java int : -2,147,483,648 à 2,147,483,647
	
	private String description;
	
//	private static final Long MAX_INT = 4294967295L;
	
	public int getReceivedValue() {
		return (this.sendValue - this.fee);
	}

}
