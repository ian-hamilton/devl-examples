package com.inertia.solutions.spring.orm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SHOPPING_CART_ITEM")
public class ShoppingCartItem implements Serializable{
	private static final long serialVersionUID = 1813624093754080050L;

	@Id
	@GeneratedValue
	@Column(name="SHOPPING_CART_ITEM_ID")
	@NotNull
	private Long shoppingCartItemId;
	
	@OneToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	public Long getShoppingCartItemId() {
		return shoppingCartItemId;
	}

	public void setShoppingCartItemId(Long shoppingCartItemId) {
		this.shoppingCartItemId = shoppingCartItemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
