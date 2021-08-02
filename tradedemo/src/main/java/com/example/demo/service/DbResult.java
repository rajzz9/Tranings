package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.repository.BaseRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Figuration;
import com.example.demo.dto.Header;
import com.example.demo.dto.TradeMessage;
import com.example.demo.dto.TrailerOutput;
import com.example.demo.entity.AccountReference;
import com.example.demo.entity.SecurityReference;
import com.example.demo.entity.Trade;
import com.example.demo.util.DbResultMapper;

import lombok.Setter;

@Component
@Setter@Getter
public class DbResult {

	private boolean result;
	private TradeMessage tradeMessage;
	private com.example.demo.dto.Error error;
	
	
	 @PersistenceContext 
	 private EntityManager entityManager;
	 
	//@Autowired private AccountReferenceRepository accountReferenceRepository;

	@Autowired
	private BaseRepository<AccountReference, String> accountReferenceRepository;
	
	@Autowired
	private DbResultMapper dbResultMapper;
	
	public AccountReference insertAccountReference(com.example.demo.dto.AccountReference accountRef) {
		AccountReference accountReference = null;
		accountReference = this.getAccountRefFromDB(accountRef);
		if(null == accountReference) {
			accountReference = dbResultMapper.accountReferenceMapper(accountRef);
			entityManager.persist(accountReference);
			this.result = true;
		} else {
			entityManager.merge(accountReference);
		}
		return accountReference;
	}

	public AccountReference insertAccountReference1(com.example.demo.dto.AccountReference accountRef) {
		AccountReference accountReference = null;
		accountReference = this.getAccountRefFromDB(accountRef);
		if(null == accountReference) {
			accountReference = dbResultMapper.accountReferenceMapper(accountRef);
			accountReference = accountReferenceRepository.save(accountReference);
			this.result = true;
		}
		return accountReference;
	}

	private AccountReference getAccountRefFromDB(com.example.demo.dto.AccountReference accountRef) {
		return null;
	}
	
	public SecurityReference insertSecurityReference(com.example.demo.dto.SecurityReference securityRef) {
		return null;
	}
	
	public Trade insertTrade(com.example.demo.entity.AccountReference accountRef,com.example.demo.entity.SecurityReference securityRef,com.example.demo.dto.Trade trade) {
		return null;
	}
	
	public boolean insertRefernceId(Trade trade, Header header) {
		return false;
	}
	
	public boolean insertMoney(Trade trade, Figuration figuration) {
		return false;
	}
	
	public boolean insertTrailerInput(Trade trade, List<com.example.demo.dto.TrailerInput> trilerInputs) {
		return false;	
	}
	
	public boolean insertTrailerOutput(Trade trade, List<TrailerOutput> trailerOutputs) {
		return false;
	}
}
