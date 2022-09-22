package com.bz.BSUserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bz.BSUserService.Dto.OrderDto;
import com.bz.BSUserService.Model.OrderModel;
import com.bz.BSUserService.Service.IOrderService;

@RestController
@RequestMapping("/bookstore/order")
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@PostMapping("/create")
	public OrderModel create(@RequestBody OrderDto orderDto) {
		return orderService.create(orderDto);
		
	}
	
	@GetMapping("/getordersforuser/{id}")
	public List<OrderModel> getOrdersForUser(@PathVariable long id){
		return orderService.getOrdersForUser(id);
	}
}
