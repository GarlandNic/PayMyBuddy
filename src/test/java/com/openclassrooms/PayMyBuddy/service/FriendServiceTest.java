package com.openclassrooms.PayMyBuddy.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassrooms.PayMyBuddy.repository.FriendRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FriendServiceTest {

	@Autowired
	FriendService ts;
	
	@MockBean
	FriendRepository tr;

}
