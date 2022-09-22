package com.bz.BSUserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bz.BSUserService.Dto.CartDto;
import com.bz.BSUserService.Model.CartModel;
import com.bz.BSUserService.Service.ICartService;

@RestController
@RequestMapping("/bookstore/cart")
public class CartController {

	@Autowired
	
	ICartService cartService;
	
	@PostMapping("/create")
	public CartModel create(@RequestBody CartDto cartDto) {
		return cartService.create(cartDto);
	}
	
	@PutMapping("/updatecart")
	public CartModel updateCare(@PathVariable Long cartId,@RequestBody CartDto cartDto) {
		return cartService.updateCart(cartId,cartDto);
	}
	@DeleteMapping("/delete/{cartId}")
	public CartModel delete(@PathVariable long id){
		return cartService.delete(id);
	}
	
	@GetMapping("/getcartforuser/{id}")
	public List<CartModel> getCartforUser(@PathVariable long id){
		return cartService.gerCartForUser(id);
	}
	
	@PutMapping("/updatequantity")
	public CartModel updateQuantity(@RequestHeader String token, @PathVariable long cartId,int quantity) {
		return cartService.updateQuantity(token,cartId,quantity);
	}
	
}
