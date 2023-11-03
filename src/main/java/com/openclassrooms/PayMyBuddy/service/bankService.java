package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.model.CreditDto;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;

@Service
public class bankService {
	
	@Autowired
	PMBUserRepository userRepo;

	public boolean creditation(CreditDto creditDto, PMBUser user) {
		if(creditDto.getValue()>0 && IbanChecker(creditDto.getIban())) {
			boolean transaction = takingFromBank(creditDto.getIban(), creditDto.getValue());
			if(transaction) {
				user.setBalance(user.getBalance() + creditDto.getValue()*100);
				userRepo.save(user);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean IbanChecker(String iban) {
		return true;
	}
	private boolean takingFromBank(String iban, int value) {
		return true;
	}

}
