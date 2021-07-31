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
@Table(name = "mny_ref")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RefernceId extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3383762411278576986L;
	@Column(name = "ref_id")
	@Id
	private String refId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trade_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Trade trade;
	@Column(name = "ref_code")
	private String refCode;
	@Column(name = "ref_value")
	private BigDecimal refValue;
}
