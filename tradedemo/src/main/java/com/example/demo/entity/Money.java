package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Objects;

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
public class Money extends AuditModel  {

	private static final long serialVersionUID = 8595034731424985365L;
	@Column(name = "mny_id")
	@Id
	private String moneyId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trade_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Trade trade;
	@Column(name="mny_source")
	private String mnySource;
	@Column(name="mny_code")
	private String mnyCode;
	@Column(name="mny_val")
	private BigDecimal mnyValue;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Money money = (Money) o;
		return Objects.equals(trade, money.trade) && Objects.equals(mnySource, money.mnySource) && Objects.equals(mnyCode, money.mnyCode) && Objects.equals(mnyValue, money.mnyValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(trade, mnySource, mnyCode, mnyValue);
	}
}
