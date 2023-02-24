package com.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.model.cart.CartItem;
import com.pizza.model.cart.CartItemPK;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemPK>{

}
