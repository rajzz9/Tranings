package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trade_ref")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Trade extends AuditModel {
	private static final long serialVersionUID = 5851354829462869687L;
	@Column(name = "trade_id")
	@Id
	private String tradeId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acct_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AccountReference accountReference;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sec_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SecurityReference securityReference;
	@Column(name = "num_qty")
	private BigDecimal numQty;
	@Column(name = "amount")
	private BigDecimal amount;

}
