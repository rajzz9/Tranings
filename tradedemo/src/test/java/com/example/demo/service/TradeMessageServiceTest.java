package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.dto.Error;
import com.example.demo.entity.Money;
import com.example.demo.exception.TradeMessageServiceException;
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

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradeMessageServiceTest {
	@InjectMocks
	private TradeMessageService tradeMessageService;
	@Spy
	private DbResult dbResult;
//	@Mock
//	private DbResultMapper dbResultMapper;
	@Mock
	private BaseRepository<com.example.demo.entity.AccountReference, String> accountReferenceRepository;

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this); //without this you will get NPE
		dbResult.setDbResultMapper(spy(DbResultMapper.class));
		dbResult.setEntityManager(mock(EntityManager.class));
	}

//	@Test
//	public void testTotalPriceOfBooks() throws SQLException {
//		when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
//		assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
//	}
	@Test
	public void testTradeMessageServiceException() {
		TradeMessage tradeMessage = prepairTradeMessage();
//		DbResult dbResultError = new DbResult();
//		Error error = new Error();
//		error.setErrorCode("PNR-TRADE-ACCT-SEC-001");
//		String s = null;
//		error.setErrorMessage("Issue in Account and Security reference: accRef: "+s+"  secRef: "+s);
//		dbResultError.setResult(false);
//		dbResultError.setError(error);
//		dbResultError.setTradeMessage(tradeMessage);

		doThrow(new TradeMessageServiceException("PNR-TRADE-ACCT-SEC-001|Issue in Account and Security reference: ")).when(dbResult).insertAccountReference(tradeMessage.getAccountreference());

		dbResult = tradeMessageService.saveTradeMessage(tradeMessage);
		assertEquals("PNR-TRADE-ACCT-SEC-001", dbResult.getError().getErrorCode());
	}

	@Test
	public void test_AccountRefInsert() {
//		dbResult.setDbResultMapper(spy(DbResultMapper.class));
//		dbResult.setEntityManager(mock(EntityManager.class));
		TradeMessage tradeMessage = prepairTradeMessage();

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

		doReturn(accRef).when(dbResult).insertAccountReference(tradeMessage.getAccountreference());
		doReturn(securityReference).when(dbResult).insertSecurityReference(tradeMessage.getSecurityReferecne());
		doReturn(tradeEntity).when(dbResult).insertTrade(accRef, securityReference, tradeMessage.getTrade());
		doReturn(true).when(dbResult).insertRefernceId(tradeEntity, tradeMessage.getHeader());
		doReturn(true).when(dbResult).insertMoney(tradeEntity, tradeMessage.getFiguration());
		doReturn(true).when(dbResult).insertTrailer(tradeEntity, tradeMessage.getTrailer());

		boolean actual = tradeMessageService.saveTradeMessage(tradeMessage).isResult();
		assertEquals(true, actual);
	}

	private TradeMessage prepairTradeMessage() {
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
		Header header = new Header();
		RefernceId ref1 = new RefernceId("123", "456");
		RefernceId ref2 = new RefernceId("456", "412");
		RefernceId ref3 = new RefernceId("789", "963");
		header.setInOutRefernceIds(Arrays.asList(ref1, ref2, ref3));
		Figuration figuration = spy(Figuration.class);
		MoneyDto moneyDto1 = new MoneyDto("COD", "USD", BigDecimal.valueOf(339.54), "987");
		MoneyDto moneyDto2 = new MoneyDto("Online", "ISD", BigDecimal.valueOf(399.24), "987");
		figuration.setInOutMoney(Arrays.asList(moneyDto1, moneyDto2));
		Trailer trailer = spy(Trailer.class);
		TrailerInput tInput1 = new TrailerInput("Code1", BigDecimal.valueOf(125.21));
		TrailerInput tInput2 = new TrailerInput("Code2", BigDecimal.valueOf(124.24));
		TrailerOutput tOutput1 = new TrailerOutput("Code1", BigDecimal.valueOf(321.02));
		TrailerOutput tOutput2 = new TrailerOutput("Code2", BigDecimal.valueOf(322.22));
		trailer.setInTrailerInput(Arrays.asList(tInput1, tInput2));
		trailer.setInTrailerOutput(Arrays.asList(tOutput1, tOutput2));

		tradeMessage.setAccountreference(accountRef);
		tradeMessage.setSecurityReferecne(securityRef);
		tradeMessage.setTrade(trade);
		tradeMessage.setHeader(header);
		tradeMessage.setFiguration(figuration);
		tradeMessage.setTrailer(trailer);
		return tradeMessage;
	}
}
