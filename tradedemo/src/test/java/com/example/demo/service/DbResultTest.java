package com.example.demo.service;

import com.example.demo.dto.AccountReference;
import com.example.demo.util.DbResultMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;

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
