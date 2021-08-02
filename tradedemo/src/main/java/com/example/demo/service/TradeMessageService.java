package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.dto.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TradeMessage;
import com.example.demo.entity.AccountReference;
import com.example.demo.entity.SecurityReference;
import com.example.demo.entity.Trade;

@Service
public class TradeMessageService {
    private Logger log = LoggerFactory.getLogger(TradeMessageService.class);

    @Autowired
    private DbResult dbResult;

    @Transactional
    public DbResult saveTradeMessage(TradeMessage tradeMessage) {
        log.debug("Trade message: " + tradeMessage);
        //DbResult dbResult = new DbResult();
        dbResult.setTradeMessage(tradeMessage);
        try {
            AccountReference accRef = dbResult.insertAccountReference1(tradeMessage.getAccountreference());
            log.info("Account ref: " + accRef);
            SecurityReference secRef = dbResult.insertSecurityReference(tradeMessage.getSecurityReferecne());
            log.info("Security ref: " + secRef);
            if (null != accRef && null != secRef) {
                log.debug("Security refId: " + secRef.getSecurityId() + " Account refId: " + accRef.getAccountId());
                Trade trade = dbResult.insertTrade(accRef, secRef, tradeMessage.getTrade());
                log.debug("Trade data inserted record successfully");
                dbResult.insertRefernceId(trade, tradeMessage.getHeader());
                log.debug("ReferenceId data inserted record successfully");
//                dbResult.insertMoney(trade, tradeMessage.getFiguration());
//                log.debug("Money data inserted record successfully");
//                dbResult.insertTrailerInput(trade, tradeMessage.getTrailer().getInTrailerInput());
//                log.debug("TrailerInput data inserted record successfully");
//                dbResult.insertTrailerOutput(trade, tradeMessage.getTrailer().getInTrailerOutput());
//                log.debug("TrailerOutput data inserted record successfully");
                dbResult.setResult(true);
            } else {
                dbResult.setResult(false);
				log.error("Issue in Account and Security reference");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
			Error error = new Error();
			error.setErrorCode("PNR-001");
			error.setErrorMessage(exception.getMessage());
			dbResult.setResult(false);
			dbResult.setError(error);
            log.error("Exception: " + exception.getMessage());
        }
        log.info("Transaction status: " + dbResult.isResult());
        return dbResult;
    }
}
