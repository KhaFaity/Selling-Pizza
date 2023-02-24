package com.pizza.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pizza.exception.AppException;
import com.pizza.exception.PizzaApiException;
import com.pizza.model.cart.Cart;
import com.pizza.model.cart.CartItem;
import com.pizza.model.cart.CartItemPK;
import com.pizza.model.role.Role;
import com.pizza.model.role.RoleName;
import com.pizza.model.user.User;
import com.pizza.security.JwtTokenProvider;
import com.pizza.service.CartService;
import com.pizza.utils.payload.ApiResponse;
import com.pizza.utils.payload.CartItemRequest;
import com.pizza.utils.payload.JwtAuthenticationResponse;
import com.pizza.utils.payload.LoginRequest;
import com.pizza.utils.payload.SignUpRequest;


@RestController
@RequestMapping("/api/carts")
public class CartController {
	@Autowired
	CartService cartService;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Cart> getCart(@PathVariable Long id) {
//		Cart cart = cartService.getCart(id);
//		return ResponseEntity.ok(cart);
//	}
	@GetMapping("/{userId}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
		Cart cart = cartService.getCartByUserId(userId);
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/items")
	public ResponseEntity<CartItem> saveOrUpdate(@RequestBody CartItemRequest item) {
		Cart cart = cartService.getCartByUserId(1L);
		
		CartItem i = null;
		if(cart != null) {
			CartItem item2 = new CartItem(cart, item.getProductId(), item.getQuantity(), item.getPrice());
			i = cartService.saveItem(item2);
			
		}
		return ResponseEntity.ok(i);
	}
	
	@DeleteMapping("/items/{productId}")
	public void removeItem(@PathVariable Long productId) {
		cartService.removeItem(new CartItemPK(1l, productId));
	}
}
