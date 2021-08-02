package com.example.demo.service;

import com.example.demo.dto.SecurityReference;
import com.example.demo.dto.Trade;
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

import java.math.BigDecimal;

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
		SecurityReference securityRef = new SecurityReference();
		securityRef.setAccountNumber(456789212);
		securityRef.setAccountType("UBC");
		securityRef.setKeyAccount("456");
		Trade trade = new Trade();
		trade.setAmount(BigDecimal.valueOf(123));
		trade.setNumQty(BigDecimal.valueOf(2));

		tradeMessage.setAccountreference(accountRef);
		tradeMessage.setSecurityReferecne(securityRef);
		tradeMessage.setTrade(trade);

		// Expected Output
		com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
		accRef.setAccountId("1234567890");
		accRef.setAccountNumer(789456);
		accRef.setAccountType("UBC");
		accRef.setKeyAccount("123456876");
		com.example.demo.entity.SecurityReference securityReference = new com.example.demo.entity.SecurityReference();
		securityReference.setSecurityId("1234567890");
		securityReference.setAccountNumer(456789212);
		securityReference.setAccountType("UBC");
		securityReference.setKeyAccount("456");
		com.example.demo.entity.Trade tradeEntity = new com.example.demo.entity.Trade();
		tradeEntity.setAccountReference(accRef);
		tradeEntity.setSecurityReference(securityReference);
		tradeEntity.setAmount(BigDecimal.valueOf(123));
		tradeEntity.setNumQty(BigDecimal.valueOf(2));

		doReturn(accRef).when(dbResult).insertAccountReference1(accountRef);
		doReturn(securityReference).when(dbResult).insertSecurityReference(securityRef);
		doReturn(tradeEntity).when(dbResult).insertTrade(accRef, securityReference, trade);

		boolean actual = tradeMessageService.saveTradeMessage(tradeMessage).isResult();
		assertEquals(true, actual);
	}

}
