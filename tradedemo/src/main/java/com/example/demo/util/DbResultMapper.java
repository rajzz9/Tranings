package com.example.demo.util;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.demo.dto.Security;
import com.example.demo.entity.RefernceId;
import com.example.demo.entity.SecurityReference;
import com.example.demo.entity.Trade;
import com.example.demo.service.DbResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.entity.AccountReference;

@Component
public class DbResultMapper {

	private Logger log = LoggerFactory.getLogger(DbResultMapper.class);

	public AccountReference accountReferenceMapper(com.example.demo.dto.AccountReference accountRef) {
		log.debug("DbResultMapper: accountReferenceMapper: started!");
		AccountReference accountReference = new AccountReference();
		accountReference.setAccountId(UUID.randomUUID().toString().toUpperCase());
		accountReference.setAccountNumer(Integer.valueOf(accountRef.getAccountNumber()));
		accountReference.setAccountType(accountRef.getAccountType());
		accountReference.setKeyAccount(accountRef.getKeyAccountNumber());
		log.debug("DbResultMapper: accountReferenceMapper: completed!");
		return accountReference;
	}

	public SecurityReference securityReferenceMapper(com.example.demo.dto.SecurityReference securityRef) {
		SecurityReference securityReference = new SecurityReference();
		log.debug("DbResultMapper: securityReferenceMapper: started!");
		securityReference.setSecurityId(UUID.randomUUID().toString().toUpperCase());
		securityReference.setAccountNumer(securityRef.getAccountNumber());
		securityReference.setAccountType(securityRef.getAccountType());
		securityReference.setKeyAccount(securityRef.getKeyAccount());
		log.debug("DbResultMapper: securityReferenceMapper: completed!");
		return securityReference;
	}

	public Trade tradeMapper(com.example.demo.dto.Trade trade, com.example.demo.entity.AccountReference accountRef,com.example.demo.entity.SecurityReference securityRef) {
		Trade tradeEntity = new Trade();
		log.debug("DbResultMapper: securityReferenceMapper: started!");
		tradeEntity.setTradeId(UUID.randomUUID().toString().toUpperCase());
		tradeEntity.setAccountReference(accountRef);
		tradeEntity.setSecurityReference(securityRef);
		tradeEntity.setNumQty(trade.getNumQty());
		tradeEntity.setAmount(trade.getAmount());
		return tradeEntity;
	}

	public RefernceId refernceIdMapper(Trade trade, com.example.demo.dto.RefernceId refernceId) {
		RefernceId refernceIdEntity = new RefernceId();
		log.debug("DbResultMapper: refernceIdMapper: started!");
		refernceIdEntity.setRefId(UUID.randomUUID().toString().toUpperCase());
		refernceIdEntity.setTrade(trade);
		refernceIdEntity.setRefCode(refernceId.getRefCode());
		refernceIdEntity.setRefValue(BigDecimal.valueOf(Long.parseLong(refernceId.getRefValue())));
		log.debug("DbResultMapper: refernceIdMapper: started!");
		return  refernceIdEntity;
	}
}
