package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.dto.*;
import com.example.demo.entity.Money;
import com.example.demo.repository.BaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.entity.AccountReference;
import com.example.demo.entity.SecurityReference;
import com.example.demo.entity.Trade;
import com.example.demo.util.DbResultMapper;

import lombok.Setter;
import lombok.Getter;

@Component
@Scope("prototype")
@Setter@Getter
public class DbResult {
	private Logger log = LoggerFactory.getLogger(DbResult.class);

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
		log.debug("Account reference: getting account ref info from DB: " + accountRef);
		accountReference = this.getAccountRefFromDB(accountRef);
		log.debug("Account reference from DB: " + accountReference);
		if(null == accountReference) {
			log.debug("Account Reference: DTO to Entity object");
			accountReference = dbResultMapper.accountReferenceMapper(accountRef);
			entityManager.persist(accountReference);
			this.result = true;
			log.debug("Account Reference: Entity persisted to DB");
		} else {
			log.debug("Account Reference: Entity merging into DB");
			entityManager.merge(accountReference);
			this.result = true;
			log.debug("Account Reference: Entity merged to DB");
		}
		log.info("Account Reference saved into DB, Id: " + accountReference.getAccountId());
		return accountReference;
	}

	public AccountReference insertAccountReference1(com.example.demo.dto.AccountReference accountRef) {
		AccountReference accountReference = null;
		accountReference = this.getAccountRefFromDB(accountRef);
		log.debug("Account reference from DB: " + accountReference);
		if(null == accountReference) {
			log.debug("Account Reference: DTO to Entity object");
			accountReference = dbResultMapper.accountReferenceMapper(accountRef);
			accountReference = accountReferenceRepository.save(accountReference);
			log.debug("Account Reference: Entity persisted to DB");
			this.result = true;
		}
		log.info("Account Reference saved into DB, Id: " + accountReference.getAccountId());
		return accountReference;
	}

	private AccountReference getAccountRefFromDB(com.example.demo.dto.AccountReference accountRef) {
		return null;
	}
	
	public SecurityReference insertSecurityReference(com.example.demo.dto.SecurityReference securityRef) {
		SecurityReference securityReference = null;
		log.debug("Security reference: getting security ref info from DB: " + securityRef);
		securityReference = this.getSecurityRefFromDB(securityRef);
		log.debug("Security reference from DB: " + securityReference);
		if(null == securityReference) {
			log.debug("Security Reference: DTO to Entity object");
			securityReference = dbResultMapper.securityReferenceMapper(securityRef);
			entityManager.persist(securityReference);
			this.result = true;
			log.debug("Security Reference: Entity persisted to DB");
		} else {
			log.debug("Security Reference: Entity merging into DB");
			entityManager.merge(securityReference);
			this.result = true;
			log.debug("Security Reference: Entity merged to DB");
		}
		log.info("Security Reference saved into DB, Id: " + securityReference.getSecurityId());
		return securityReference;
	}

	private SecurityReference getSecurityRefFromDB(com.example.demo.dto.SecurityReference securityRef) {
		return null;
	}
	
	public Trade insertTrade(com.example.demo.entity.AccountReference accountRef,com.example.demo.entity.SecurityReference securityRef,com.example.demo.dto.Trade trade) {
		Trade tradeEntity = null;
		log.debug("Trade insert entity: accountId: " + accountRef.getAccountId() + " securityId: "+ securityRef.getSecurityId() );
		if(null != accountRef && null != securityRef) {
			log.debug("Trade : DTO to Entity object");
			tradeEntity = dbResultMapper.tradeMapper(trade, accountRef, securityRef);
			entityManager.persist(tradeEntity);
			log.debug("Trade : Entity persisted into DB");
			this.result = true;
		}
		log.info("Trade saved into DB, Id: " + tradeEntity.getTradeId());
		return tradeEntity;
	}
	
	public boolean insertRefernceId(Trade trade, Header header) {
		boolean status = false;
		log.debug("ReferenceId : tradeId: " + trade.getTradeId());
		if(null != header && header.getInOutRefernceIds().size() > 0){
			List<RefernceId> refernceIds = header.getInOutRefernceIds();
			log.debug("ReferenceId : size: " + refernceIds.size());
			for (RefernceId refernceId : refernceIds ) {
				com.example.demo.entity.RefernceId refernceIdEntity = null;
				log.debug("ReferenceId : DTO to Entity object");
				refernceIdEntity = dbResultMapper.refernceIdMapper(trade, refernceId);
				entityManager.persist(refernceIdEntity);
				log.debug("ReferenceId : Entity persisted into DB");
				status =  true;
				this.result = true;
				log.info("ReferenceId saved into DB, Id: " + refernceIdEntity.getRefId());
			}
		}
		return status;
	}
	
	public boolean insertMoney(Trade trade, Figuration figuration) {
		boolean status = false;
		log.debug("Money : tradeId: " + trade.getTradeId());
		if(null != figuration && figuration.getInOutMoney().size() > 0){
			List<MoneyDto> moneyList = figuration.getInOutMoney();
			log.debug("Money : size: " + moneyList.size());
			for (MoneyDto moneyDto : moneyList) {
				Money moneyEntity = null;
				log.debug("Money : DTO to Entity object");
				moneyEntity = dbResultMapper.moneyMapper(trade, moneyDto);
				entityManager.persist(moneyEntity);
				log.debug("Money : Entity persisted into DB");
				status =  true;
				this.result = true;
				log.info("Money saved into DB, Id: " + moneyEntity.getMoneyId());
			}
		}
		return status;
	}

	public boolean insertTrailer(Trade trade, Trailer trailer){
		boolean status = false;
		log.debug("Trailer : tradeId: " + trade.getTradeId());
		if(null != trailer && trailer.getInTrailerInput().size() > 0) {
			List<TrailerInput> trailerInputs = trailer.getInTrailerInput();
			log.debug("TrailerInput : size: " + trailerInputs.size());
			for (TrailerInput tInput : trailerInputs) {
				com.example.demo.entity.TrailerInput tInputEntity = null;
				log.debug("TrailerInput : DTO to Entity object");
				tInputEntity = dbResultMapper.trailerInputMapper(trade, tInput);
				entityManager.persist(tInputEntity);
				log.debug("TrailerInput : Entity persisted into DB");
				status =  true;
				this.result = true;
				log.info("TrailerInput saved into DB, Id: " + tInputEntity.getTrlInputId());
			}
		}
		if(status && null != trailer && trailer.getInTrailerOutput().size() > 0) {
			List<TrailerOutput> trailerOutputs = trailer.getInTrailerOutput();
			log.debug("TrailerOutput : size: " + trailerOutputs.size());
			for (TrailerOutput tOutput: trailerOutputs) {
				com.example.demo.entity.TrailerOutput tOutputEntity = null;
				log.debug("TrailerOutput : DTO to Entity object");
				tOutputEntity = dbResultMapper.trailerOutputMapper(trade, tOutput);
				entityManager.persist(tOutputEntity);
				log.debug("TrailerOutput : Entity persisted into DB");
				status =  true;
				this.result = true;
				log.info("TrailerOutput saved into DB, Id: " + tOutputEntity.getTrlOutputId());
			}
		}
		return status;
	}


}
