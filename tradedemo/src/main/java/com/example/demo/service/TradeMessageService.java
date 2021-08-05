package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.dto.Error;
import com.example.demo.exception.TradeMessageServiceException;
import com.example.demo.util.ErrorMessage;
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
        boolean flag = false;
        log.debug("Trade message: " + tradeMessage);
        dbResult.setTradeMessage(tradeMessage);
        try {
            AccountReference accRef = dbResult.insertAccountReference(tradeMessage.getAccountreference());
            log.info("Account ref: " + accRef);
            SecurityReference secRef = dbResult.insertSecurityReference(tradeMessage.getSecurityReferecne());
            log.info("Security ref: " + secRef);
            if (null != accRef && null != secRef) {
                log.debug("Security refId: " + secRef.getSecurityId() + " Account refId: " + accRef.getAccountId());
                Trade trade = dbResult.insertTrade(accRef, secRef, tradeMessage.getTrade());
                if(null == trade) throw new TradeMessageServiceException(ErrorMessage.errorMessages.get("PNR-TRADEAPI-TRADE-001"));
                log.debug("Trade data inserted record successfully");
                flag = dbResult.insertRefernceId(trade, tradeMessage.getHeader());
                if(true == flag) {
                    log.debug("ReferenceId data inserted record successfully");
                    flag = dbResult.insertMoney(trade, tradeMessage.getFiguration());
                    log.debug("Money data inserted record successfully");
                } else throw new TradeMessageServiceException(ErrorMessage.errorMessages.get("PNR-TRADEAPI-REFID-001"));
                if(true == flag) {
                    flag = dbResult.insertTrailer(trade, tradeMessage.getTrailer());
                    log.debug("Trailer Input and Output records inserted successfully");
                }else throw new TradeMessageServiceException(ErrorMessage.errorMessages.get("PNR-TRADEAPI-MNY-001"));
                if(false == flag)
                    throw new TradeMessageServiceException(ErrorMessage.errorMessages.get("PNR-TRADEAPI-TRAILER-001"));
                dbResult.setResult(flag);
            } else {
                dbResult.setResult(false);
                log.error("Issue in Account and Security reference: accRef: " + accRef +" secRef: " + secRef);
                throw new TradeMessageServiceException(ErrorMessage.errorMessages.get("PNR-TRADEAPI-MNY-001")+ "accRef: " + accRef +" secRef: " + secRef);
            }
        } catch (TradeMessageServiceException exception) {
            //exception.printStackTrace();
            Error error = new Error();
            error.setErrorCode(exception.getMessage().split("\\|")[0]);
            error.setErrorMessage(exception.getMessage().split("\\|")[1]);
            dbResult.setResult(false);
            dbResult.setError(error);
            log.error("Exception: " + exception.getMessage());
        }
        log.info("Transaction status: " + dbResult.isResult());
        return dbResult;
    }
}
