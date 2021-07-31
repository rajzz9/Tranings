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
@Table(name = "trl_Output")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrailerOutput extends AuditModel {
	private static final long serialVersionUID = 8250853471095350564L;
	@Column(name = "trlOutput_id")
	@Id
	private String trlOutputId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trade_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Trade trade;
	@Column(name = "output_code")
	private String outputCode;
	@Column(name = "output_value")
	private BigDecimal outputValue;
}
