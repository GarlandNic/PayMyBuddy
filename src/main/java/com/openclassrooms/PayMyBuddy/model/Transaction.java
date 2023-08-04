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
	private Long value=0L;
	
	// not a computed value because fee rate could change over time
	private Long fee=0L;
	// sql integer unsigned : 0 - 4,294,967,295
	// java int : -2,147,483,648 à 2,147,483,647
	
	private String description;
	
	private static final Long MAX_INT = 4294967295L;
	
	public void setValue(Long val) throws UnexpectedException {
		if(val>MAX_INT) {
			logger.error("Too big value");
			throw new UnexpectedException("Too big value");
		} else {
			this.value = val;
		}
	}	
	
	public void setFee(Long f) throws UnexpectedException {
		if(f>MAX_INT) {
			logger.error("Too big fee");
			throw new UnexpectedException("Too big fee");
		} else {
			this.fee = f;
		}
	}

}
