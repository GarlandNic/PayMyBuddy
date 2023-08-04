/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.rmi.UnexpectedException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private final static Logger logger = LogManager.getLogger("Transaction");

	@Id
	private String senderEmail;
	
	@Id
	private String recipientEmail;
	
	@Id
	private LocalDate transferTime;
	
	// value in cents
	private int value=0;
	
	// not a computed value because fee rate could change over time
	private int fee=0;
	// sql integer unsigned : 0 - 4,294,967,295
	// java int : -2,147,483,648 à 2,147,483,647
	
	private String description;
	
//	private static final Long MAX_INT = 4294967295L;
	
	public void setValue(int val) throws UnexpectedException {
		if(val<0) {
			logger.error("negative value");
			throw new UnexpectedException("negative value");
		} else {
			this.value = val;
		}
	}	
	
	public void setFee(int f) throws UnexpectedException {
		if(f<0) {
			logger.error("negative fee");
			throw new UnexpectedException("negative fee");
		} else {
			this.fee = f;
		}
	}

}
