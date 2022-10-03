package com.bz.BSUserService.Model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.bz.BSUserService.Dto.CartDto;

import lombok.Data;

@Entity
@Data
public class CartModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
    private UserModel user;
	@OneToOne
    private BookModel book;
	private Integer quantity;
	private Integer totalPrice;
	
	public CartModel(CartDto cartDto, BookModel bookModel, UserModel userModel) {
		this.quantity = cartDto.getQuantity();
		this.totalPrice=cartDto.getQuantity()*bookModel.getPrice();
		this.book=bookModel;
		this.user=userModel;
	}

	public CartModel() {
		super();
	}
	
}
