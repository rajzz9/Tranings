package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_contact", catalog = "test")
public class UsersContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private Integer phoneNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName="user_id")
	private Users users;

	public UsersContact() {
	}

	public Integer getId() {
		return id;
	}

	public UsersContact setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public UsersContact setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}

	public Users getUsers() {
		return users;
	}

	public UsersContact setUsers(Users users) {
		this.users = users;
		return this;
	}
	
	

}
