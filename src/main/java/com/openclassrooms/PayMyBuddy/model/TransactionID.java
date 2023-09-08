/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author Nicolas Garland
 *
 */
@Data
public class TransactionID {

	private String senderEmail;
	private String recipientEmail;
	private LocalDate transferTime;

}
