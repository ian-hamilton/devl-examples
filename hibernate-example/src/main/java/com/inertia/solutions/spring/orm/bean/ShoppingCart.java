package com.inertia.solutions.spring.orm.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = -650836390926635480L;

	@Id
	@Column(name="SHOPPING_CART_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shopping_cart_id_seq")
	@SequenceGenerator(name="shopping_cart_id_seq", sequenceName="shopping_cart_id_seq", allocationSize=1)
	@NotNull
	private Long shoppingCartId;
	
	@Column(name = "USER_NAME")
	@NotNull
	private String userName;

	@Column(name = "TOTAL")
	private Float total;

	@OneToMany
	@JoinTable(name = "SHOPPING_ITEMS", 
		joinColumns = @JoinColumn(name = "SHOPPING_CART_ID"), 
		inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>();

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Set<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder( "ShoppingCart [shoppingCartId=" + shoppingCartId + ", userName="
				+ userName + ", total=" + total + "]");
		for(ShoppingCartItem cartItem:this.shoppingCartItems) {
			builder.append(cartItem.getItem().toString());
		}
		return builder.toString();
	}

}
