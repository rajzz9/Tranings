package com.example.demo;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.AccountReference;
import com.example.demo.dto.TradeMessage;
import com.example.demo.service.TradeMessageService;
import com.example.demo.util.DbResultMapper;

@SpringBootTest
class TradedemoApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	@Mock
	private EntityManager entityManager;
	@Autowired
	private TradeMessageService tradeMessageService;
	@Spy
	private DbResultMapper dbResultMapper;
	

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
