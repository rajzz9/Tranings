package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TradeMessage {

	private MessageHeader messageHeader;
	private Header header;
	private Trade trade;
	private Figuration figuration;
	private Trailer trailer;
	private Account account;
	private Security security;
	private Currency currency;
	private Ubc ubc;
	private AccountReference accountreference;
	private SecurityReference securityReferecne;
	private Retry retry;
	
}
