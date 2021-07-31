package com.example.demo.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.entity.AccountReference;

@Component
public class DbResultMapper {

	public AccountReference accountReferenceMapper(com.example.demo.dto.AccountReference accountRef) {
		AccountReference accountReference = new AccountReference();
		accountReference.setAccountId(UUID.randomUUID().toString().toUpperCase());
		accountReference.setAccountNumer(Integer.valueOf(accountRef.getAccountNumber()));
		accountReference.setAccountType(accountRef.getAccountType());
		accountReference.setKeyAccount(accountRef.getKeyAccountNumber());
		return accountReference;
	}
}
