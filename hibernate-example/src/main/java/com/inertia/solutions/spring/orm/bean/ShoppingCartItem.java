package com.inertia.solutions.spring.orm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SHOPPING_CART_ITEM")
public class ShoppingCartItem implements Serializable{
	private static final long serialVersionUID = 1813624093754080050L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shopping_cart_item_id_seq")
	@SequenceGenerator(name="shopping_cart_item_id_seq", sequenceName="shopping_cart_item_id_seq", allocationSize=1)
	@Column(name="SHOPPING_CART_ITEM_ID")
	@NotNull
	private Long shoppingCartItemId;
	
	@OneToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="SHOPPING_CART_ID")
	private ShoppingCart shoppingCart;

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

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
