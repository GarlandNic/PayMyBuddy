package com.openclassrooms.PayMyBuddy.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassrooms.PayMyBuddy.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TransactionServiceTest {

	@Autowired
	TransactionService ts;
	
	@MockBean
	TransactionRepository tr;

}
