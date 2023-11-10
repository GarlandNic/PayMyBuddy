package com.openclassrooms.PayMyBuddy.dto;

import lombok.Data;

@Data
public class CreditDto {
	
	private int value; // in euro
	
	private String iban;

}
