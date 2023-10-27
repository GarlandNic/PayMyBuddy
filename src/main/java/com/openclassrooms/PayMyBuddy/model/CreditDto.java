package com.openclassrooms.PayMyBuddy.model;

import lombok.Data;

@Data
public class CreditDto {
	
	private int value; // in euro
	
	private String iban;

}
