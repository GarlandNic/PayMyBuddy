package com.openclassrooms.PayMyBuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.dto.CreditDto;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;

@Service
public class BankService {
	
	@Autowired
	PMBUserRepository userRepo;

	/**
	 * add money to the balance's user by taking it from the bank
	 * @param creditDto
	 * @param user
	 * @return
	 */
	public boolean creditation(CreditDto creditDto, PMBUser user) {
		if(creditDto.getValue()>0 && IbanChecker(creditDto.getIban())) {
			boolean transaction = takingFromBank(creditDto.getIban(), creditDto.getValue());
			if(transaction) {
				user.increaseAccount(creditDto.getValue()*100);
				userRepo.save(user);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * remove money to the balance's user and giving it to the bank
	 * @param creditDto
	 * @param user
	 * @return
	 */
	public boolean debitation(CreditDto creditDto, PMBUser user) {
		if(creditDto.getValue()>0 && IbanChecker(creditDto.getIban())) {
			boolean transaction = givingToBank(creditDto.getIban(), creditDto.getValue());
			if(transaction) {
				user.decreaseAccount(creditDto.getValue()*100);
				userRepo.save(user);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Fake interaction with the bank. Always true.
	 * @param iban
	 * @return
	 */
	private boolean IbanChecker(String iban) {
		return true;
	}
	/**
	 * @see #IbanChecker(String))
	 */
	private boolean takingFromBank(String iban, int centValue) {
		return true;
	}
	/**
	 * @see #IbanChecker(String)
	 */
	private boolean givingToBank(String iban, int centValue) {
		return true;
	}

}
