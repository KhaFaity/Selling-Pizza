package com.pizza.service;

import java.util.List;

import com.pizza.model.cart.Cart;
import com.pizza.model.cart.CartItem;
import com.pizza.model.cart.CartItemPK;

public interface CartService {
	public Cart addCart(Cart cart);
	public CartItem saveItem(CartItem item);
	public boolean removeItem(CartItemPK itemId);
	public boolean deleteCart(Long cartId);
	public Cart getCart(Long cartId);
	public Cart getCartByUserId(Long userId);
}
