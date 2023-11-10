/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @author Nicolas Garland
 *
 */
@Data
public class TransactionID {

	private String senderEmail;
	private String recipientEmail;
	private LocalDateTime transferTime;

}
