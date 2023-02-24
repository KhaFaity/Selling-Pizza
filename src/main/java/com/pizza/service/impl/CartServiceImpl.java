package com.pizza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.model.cart.Cart;
import com.pizza.model.cart.CartItem;
import com.pizza.model.cart.CartItemPK;
import com.pizza.repository.CartItemRepository;
import com.pizza.repository.CartRepository;
import com.pizza.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartItemRepository itemRepository;
	@Override
	public Cart addCart(Cart c) {
		Cart cart = cartRepository.saveAndFlush(c);
		return cart;
	}

	@Override
	public CartItem saveItem(CartItem i) {
		CartItem item = itemRepository.save(i);
		return item;
	}

	@Override
	public boolean removeItem(CartItemPK itemId) {
		try {
			itemRepository.deleteById(itemId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteCart(Long cartId) {
		try {
			cartRepository.deleteById(cartId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Cart getCart(Long cartId) {
		Cart cart  = cartRepository.findById(cartId).get();
		return cart;
	}

	@Override
	public Cart getCartByUserId(Long userId) {
		Cart cart  = cartRepository.findByUserId(userId);
		return cart;
	}

}
