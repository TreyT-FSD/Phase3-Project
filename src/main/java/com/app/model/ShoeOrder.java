package com.app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="shoe_order")
public class ShoeOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@OneToOne
	private User orderCustomer;
	
	@OneToOne
	private Shoe orderShoe;
	
	private LocalDate orderTimeStamp;
	

	public ShoeOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoeOrder(User orderCustomer, Shoe orderShoe, LocalDate orderTimeStamp) {
		super();
		this.orderCustomer = orderCustomer;
		this.orderShoe = orderShoe;
		this.orderTimeStamp = orderTimeStamp;
	}

	public ShoeOrder(long orderId, User orderCustomer, Shoe orderShoe, LocalDate orderTimeStamp) {
		super();
		this.orderId = orderId;
		this.orderCustomer = orderCustomer;
		this.orderShoe = orderShoe;
		this.orderTimeStamp = orderTimeStamp;
	}
	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public User getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(User orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public Shoe getOrderShoe() {
		return orderShoe;
	}

	public void setOrderShoe(Shoe orderShoe) {
		this.orderShoe = orderShoe;
	}

	public LocalDate getOrderTimeStamp() {
		return orderTimeStamp;
	}

	public void setOrderTimeStamp(LocalDate orderTimeStamp) {
		this.orderTimeStamp = orderTimeStamp;
	}
	

	@Override
	public String toString() {
		return "ShoeOrder [orderId=" + orderId + ", orderCustomer=" + orderCustomer + ", orderShoe=" + orderShoe
				+ ", orderTimeStamp=" + orderTimeStamp + "]";
	}
}
