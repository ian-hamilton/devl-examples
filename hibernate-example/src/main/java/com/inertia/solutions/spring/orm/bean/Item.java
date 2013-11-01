package com.inertia.solutions.spring.orm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item implements Serializable{
	private static final long serialVersionUID = 2236530886559182630L;

	@Id
	@GeneratedValue
	@Column(name="ITEM_ID")
	private Long itemId;
	
	@Column(name="itemName")
	private String itemName;
	
	@Column(name="ITEM_PRICE")
	private Float itemPrice;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

}
