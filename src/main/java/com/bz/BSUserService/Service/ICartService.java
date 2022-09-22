package com.bz.BSUserService.Service;

import java.util.List;

import com.bz.BSUserService.Dto.CartDto;
import com.bz.BSUserService.Model.CartModel;

public interface ICartService {

	CartModel create(CartDto cartDto);

	CartModel delete(long id);

	CartModel updateQuantity(String token, long cartId, int quantity);

	CartModel updateCart(Long cartId, CartDto cartDto);

	List<CartModel> gerCartForUser(long id);

}
