package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.AccountReference;
import com.example.demo.util.DbResultMapper;

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
		//com.example.demo.entity.AccountReference accRef = dbResult.insertAccountReference(accountRef);
		//assertNotNull(accRef);
		
		// Expected Output
		com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
		accRef.setAccountNumer(789456);
		accRef.setAccountType("UBC");
		accRef.setKeyAccount("123456876");
		
		//when(dbResult.insertAccountReference(accountRef)).thenReturn()
		//assertEquals(accRef.getAccountNumer(), dbResult.insertAccountReference(accountRef).getAccountNumer());
		assertNotNull(dbResult.insertAccountReference(accountRef).getAccountId());
	}

}
