package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Orderlines")
public class Orderlines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer qty;
	
	private Double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_order_id", referencedColumnName = "id")
	private CustomerOrder customerOrder;

	public Orderlines() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public CustomerOrder getOrder() {
		return customerOrder;
	}

	public void setOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
		customerOrder.getOrderlines().add(this);
	}

	@Override
	public String toString() {
		return "Orderlines [id=" + id + ", qty=" + qty + ", amount=" + amount + ", order=" + customerOrder + "]";
	}

}
