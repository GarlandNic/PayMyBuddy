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


@Entity
@Data
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	private LocalDateTime transferTime;
	
	private int sentValueInCent=0;
	
	private int taxedFeeInCent=0;
	
	private String description;
	
	/**
	 * Compute the received money from sendValue and fee
	 * @return
	 */
	public int getReceivedValueInCent() {
		return (this.sentValueInCent - this.taxedFeeInCent);
	}
	
	@ManyToOne
	@JoinColumn(name = "friendship_id")
	private Friend friendship;

}
