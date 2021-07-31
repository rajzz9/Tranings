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
@Table(name = "trl_input")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrailerInput extends AuditModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7281570633413506977L;
	@Column(name = "ref_id")
	@Id
	private String trlInputId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trade_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Trade trade;
	@Column(name = "input_code")
	private String inputCode;
	@Column(name = "input_value")
	private BigDecimal inputValue;
}
