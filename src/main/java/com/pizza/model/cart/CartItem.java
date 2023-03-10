package com.pizza.model.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart_items")
@IdClass(CartItemPK.class)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CartItem {
	@Id
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "cartId")
	private Cart cart;
	@Id
	private Long productId;
	private int quantity;
	private double price;
	
	
	public CartItemPK getId() {
		return new CartItemPK(cart.getId(), productId);
	}
	public void setId(CartItemPK id) {
		this.productId = id.getProductId();
		this.cart.setId(id.getCart());
	}
}
