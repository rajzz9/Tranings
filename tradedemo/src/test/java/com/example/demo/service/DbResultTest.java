package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.util.DbResultMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class DbResultTest {

	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private DbResult dbResult;
	@Spy
	private DbResultMapper dbResultMapper;
	
	// @Mock
	// private AccountReferenceRepository accountReferenceRepository;

	@Test
	public void test_InsertAccountReference() {
		// Actual input
		AccountReference accountRef = new AccountReference();
		accountRef.setAccountNumber("789456");
		accountRef.setAccountType("UBC");
		accountRef.setKeyAccountNumber("123456876");

		// Expected Output
		com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
		accRef.setAccountNumer(789456);
		accRef.setAccountType("UBC");
		accRef.setKeyAccount("123456876");

		doNothing().when(entityManager).persist(accRef);
		dbResult.insertAccountReference(accountRef);
		verify(entityManager, times(1)).persist(accRef);
	}

	@Test
	public void test_InsertSecurityReference(){
		SecurityReference securityRef = new SecurityReference();
		securityRef.setAccountNumber(456789212);
		securityRef.setAccountType("UBC");
		securityRef.setKeyAccount("456");

		com.example.demo.entity.SecurityReference securityReference = new com.example.demo.entity.SecurityReference();
		securityReference.setAccountNumer(456789212);
		securityReference.setAccountType("UBC");
		securityReference.setKeyAccount("456");

		doNothing().when(entityManager).persist(securityReference);
		dbResult.insertSecurityReference(securityRef);
		verify(entityManager, times(1)).persist(securityReference);
	}

	@Test
	public void test_InsertTrade() {
		com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
		accRef.setAccountId("123");
		accRef.setAccountNumer(789456);
		accRef.setAccountType("UBC");
		accRef.setKeyAccount("123456876");
		com.example.demo.entity.SecurityReference securityReference = new com.example.demo.entity.SecurityReference();
		securityReference.setSecurityId("987");
		securityReference.setAccountNumer(456789212);
		securityReference.setAccountType("UBC");
		securityReference.setKeyAccount("456");

		Trade trade = new Trade();
		trade.setAmount(BigDecimal.valueOf(123));
		trade.setNumQty(BigDecimal.valueOf(2));

		com.example.demo.entity.Trade tradeEntity = new com.example.demo.entity.Trade();
		tradeEntity.setSecurityReference(securityReference);
		tradeEntity.setAccountReference(accRef);
		tradeEntity.setAmount(BigDecimal.valueOf(123));
		tradeEntity.setNumQty(BigDecimal.valueOf(2));

		doNothing().when(entityManager).persist(tradeEntity);
		com.example.demo.entity.Trade tradeEntityActual = dbResult.insertTrade(accRef,securityReference, trade);
		assertEquals(tradeEntity, tradeEntityActual);
	}

	@Test
	public void testInsertRefernceId(){
		com.example.demo.entity.Trade trade = spy(com.example.demo.entity.Trade.class);
		trade.setTradeId("147852369");
		Header header = spy(Header.class);
		RefernceId ref1 = new RefernceId("123", "456");
		RefernceId ref2 = new RefernceId("456", "412");
		RefernceId ref3 = new RefernceId("789", "963");
		header.setInOutRefernceIds(Arrays.asList(ref1, ref2, ref3));

		com.example.demo.entity.RefernceId refernceIdEntity1 = new com.example.demo.entity.RefernceId();
		refernceIdEntity1.setRefId("1");
		refernceIdEntity1.setRefValue(BigDecimal.valueOf(456));
		refernceIdEntity1.setTrade(trade);
		refernceIdEntity1.setRefCode("123");

		com.example.demo.entity.RefernceId refernceIdEntity2 = new com.example.demo.entity.RefernceId();
		refernceIdEntity2.setRefId("2");
		refernceIdEntity2.setRefValue(BigDecimal.valueOf(412));
		refernceIdEntity2.setTrade(trade);
		refernceIdEntity2.setRefCode("456");

		com.example.demo.entity.RefernceId refernceIdEntity3 = new com.example.demo.entity.RefernceId();
		refernceIdEntity3.setRefId("3");
		refernceIdEntity3.setRefValue(BigDecimal.valueOf(963));
		refernceIdEntity3.setTrade(trade);
		refernceIdEntity3.setRefCode("789");

		doNothing().when(entityManager).persist(refernceIdEntity1);
		doNothing().when(entityManager).persist(refernceIdEntity2);
		doNothing().when(entityManager).persist(refernceIdEntity3);

		boolean actual = dbResult.insertRefernceId(trade, header);
		assertEquals(true, actual);
	}
	@Test
	public void test_Given_AAccountReference_When_insertAccountReference_Then_AccountRefAdded() {
		// Given - Arrange
		AccountReference accountRef = new AccountReference();
		accountRef.setAccountNumber("789456");
		accountRef.setAccountType("UBC");
		accountRef.setKeyAccountNumber("123456876");
		com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
		accRef.setAccountNumer(789456);
		accRef.setAccountType("UBC");
		accRef.setKeyAccount("123456876");
		BDDMockito.willDoNothing().given(entityManager).persist(accRef);

		// When - Act
		dbResult.insertAccountReference(accountRef);

		// Then - Assert/Verify
		then(entityManager).should().persist(accRef);
	}
}
