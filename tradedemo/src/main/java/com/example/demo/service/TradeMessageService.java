package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TradeMessage;
import com.example.demo.entity.AccountReference;
import com.example.demo.entity.SecurityReference;
import com.example.demo.entity.Trade;

@Service
public class TradeMessageService {

	@Transactional
	public DbResult saveTradeMessage(TradeMessage tradeMessage) {
		DbResult dbResult = new DbResult();
		dbResult.setTradeMessage(tradeMessage);
		AccountReference accRef = dbResult.insertAccountReference(tradeMessage.getAccountreference());
		//SecurityReference secRef = dbResult.insertSecurityReference(tradeMessage.getSecurityReferecne());
		//if (null != accRef && null != secRef) {
			//Trade trade = dbResult.insertTrade(accRef, secRef, tradeMessage.getTrade());
			//dbResult.insertRefernceId(trade, tradeMessage.getHeader());
			//dbResult.insertMoney(trade, tradeMessage.getFiguration());
			//dbResult.insertTrailerInput(trade, tradeMessage.getTrailer().getInTrailerInput());
			//dbResult.insertTrailerOutput(trade, tradeMessage.getTrailer().getInTrailerOutput());
			//dbResult.setResult(true);
		//} else {
			//dbResult.setResult(false);
			//System.out.println("Issue in Account and Security reference");
		//}
		return dbResult;
	}
}
