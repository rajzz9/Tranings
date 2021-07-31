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
@Table(name = "security_ref")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SecurityReference extends AuditModel {
	private static final long serialVersionUID = 5920683828029158788L;
	@Id
	@Column(name = "sec_id")
	private String securityId;
	@Column(name = "sec_num")
	private Integer accountNumer;
	@Column(name = "sec_type")
	private String accountType;
	@Column(name = "key_sec")
	private String keyAccount;
}
