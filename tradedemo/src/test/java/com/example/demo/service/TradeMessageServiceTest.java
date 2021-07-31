package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.AccountReference;
import com.example.demo.dto.TradeMessage;

@ExtendWith(MockitoExtension.class)
public class TradeMessageServiceTest {

	@Autowired
	private TradeMessageService tradeMessageService;

	@Test
	public void test_AccountRefInsert() {
		TradeMessage tradeMessage = new TradeMessage();
		AccountReference accountRef = new AccountReference();
		accountRef.setAccountNumber("abcdfd");
		accountRef.setAccountType("UBC");
		accountRef.setKeyAccountNumber("123456876");
		tradeMessageService.saveTradeMessage(tradeMessage);
	}

}
