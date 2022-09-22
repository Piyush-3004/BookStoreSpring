package com.bz.BSUserService.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.bz.BSUserService.Dto.OrderDto;

import lombok.Data;

@Entity
@Data
public class OrderModel {

	public OrderModel(OrderDto orderDto, BookModel bookModel, UserModel userModel) {
		this.address=orderDto.getAddress();
		this.price=orderDto.getPrice();
		this.quantity=orderDto.getQuantity();
		this.user=userModel;
		this.book=bookModel;		
	}
//	public OrderModel(OrderDto orderDto, BookModel bookModel, UserModel userModel) {
//		
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@CreationTimestamp
	private LocalDate OrderDate;
	private double price;
	private int quantity;
	private String address;
	@OneToOne
    @JoinColumn(name="userID")
	private UserModel user;
	@OneToOne
    @JoinColumn(name="bookID")
	private BookModel book;
	private boolean cancel;
	
	
	public OrderModel() {
		super();
	}


}
