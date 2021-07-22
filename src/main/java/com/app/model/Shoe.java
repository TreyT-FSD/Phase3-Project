package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoe")
public class Shoe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shoeId;
	
	@Column
	private String shoeName;
	
	@Column
	private double shoePrice;
	
	//handling enums with JPA - https://www.baeldung.com/jpa-persisting-enums-in-jpa
	@Enumerated(EnumType.STRING)
	private ShoeCategory shoeCategory;
	
	
	public Shoe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shoe(String shoeName, double shoePrice, ShoeCategory shoeCategory) {
		super();
		this.shoeName = shoeName;
		this.shoePrice = shoePrice;
		this.shoeCategory = shoeCategory;
	}

	public Shoe(long shoeId, String shoeName, double shoePrice, ShoeCategory shoeCategory) {
		super();
		this.shoeId = shoeId;
		this.shoeName = shoeName;
		this.shoePrice = shoePrice;
		this.shoeCategory = shoeCategory;
	}
	

	public long getShoeId() {
		return shoeId;
	}

	public void setShoeId(long shoeId) {
		this.shoeId = shoeId;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public double getShoePrice() {
		return shoePrice;
	}

	public void setShoePrice(double shoePrice) {
		this.shoePrice = shoePrice;
	}

	public ShoeCategory getShoeCategory() {
		return shoeCategory;
	}

	public void setShoeCategory(ShoeCategory shoeCategory) {
		this.shoeCategory = shoeCategory;
	}

	@Override
	public String toString() {
		return "Shoe [shoeId=" + shoeId + ", shoeName=" + shoeName + ", shoePrice=" + shoePrice + ", shoeCategory="
				+ shoeCategory + "]";
	}
	

	
}
