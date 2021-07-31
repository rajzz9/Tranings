package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acct_ref")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountReference extends AuditModel {
	private static final long serialVersionUID = -5874755387783939204L;
	@Id
	@Column(name = "acct_id")
	private String accountId;
	@Column(name = "account_num")
	private Integer accountNumer;
	@Column(name = "acct_type")
	private String accountType;
	@Column(name = "key_acct")
	private String keyAccount;
}
