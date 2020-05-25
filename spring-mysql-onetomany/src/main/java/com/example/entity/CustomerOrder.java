package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "CustomerOrder")
@Table(name = "customer_order")
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "customer_name")
	private String customerName;

	@OneToMany(
	        mappedBy = "customerOrder",
	        cascade = CascadeType.PERSIST,
	        fetch = FetchType.LAZY
	    )
	private Set<Orderlines> orderlines;

	public CustomerOrder() {
		orderlines = new HashSet<>();
	}

	public CustomerOrder(String customerName) {
		this.customerName = customerName;
		orderlines = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Orderlines> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(Set<Orderlines> orderlines) {
		this.orderlines = orderlines;
		for (Orderlines orderline : orderlines) {
			//book.setBookCategory(this);
			orderline.setOrder(this);
		}
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", orderlines=" + orderlines + "]";
	}

}
