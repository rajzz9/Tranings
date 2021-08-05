package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter@Getter
public class MoneyDto {

	private String moneyType;
	private String moneySource;
	private BigDecimal amount;
	private String moneyCode;
}
