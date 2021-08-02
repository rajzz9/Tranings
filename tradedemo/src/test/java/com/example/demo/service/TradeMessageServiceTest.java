package com.example.demo.service;

import com.example.demo.repository.BaseRepository;
import com.example.demo.util.DbResultMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.AccountReference;
import com.example.demo.dto.TradeMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradeMessageServiceTest {
	@InjectMocks
	private TradeMessageService tradeMessageService;
	@Spy
	private DbResult dbResult;
	@Mock
	private DbResultMapper dbResultMapper;
	@Mock
	private BaseRepository<com.example.demo.entity.AccountReference, String> accountReferenceRepository;

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this); //without this you will get NPE
	}

	@Test
	public void test_AccountRefInsert() {
		TradeMessage tradeMessage = new TradeMessage();
		// Actual input

		AccountReference accountRef = new AccountReference();
		accountRef.setAccountNumber("789456");
		accountRef.setAccountType("UBC");
		accountRef.setKeyAccountNumber("123456876");
		tradeMessage.setAccountreference(accountRef);
		// Expected Output
		com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
		accRef.setAccountId("1234567890");
		accRef.setAccountNumer(789456);
		accRef.setAccountType("UBC");
		accRef.setKeyAccount("123456876");

		doReturn(accRef).when(dbResult).insertAccountReference1(accountRef);

		boolean actual = tradeMessageService.saveTradeMessage(tradeMessage).isResult();
		assertEquals(true, actual);
	}

}
