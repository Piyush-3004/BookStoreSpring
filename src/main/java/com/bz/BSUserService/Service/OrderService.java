package com.bz.BSUserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bz.BSUserService.Dto.OrderDto;
import com.bz.BSUserService.Model.BookModel;
import com.bz.BSUserService.Model.OrderModel;
import com.bz.BSUserService.Model.UserModel;
import com.bz.BSUserService.Repository.IBookRepository;
import com.bz.BSUserService.Repository.IOrderRepository;
import com.bz.BSUserService.Repository.IUserRepository;
import com.bz.BSUserService.Util.TokenUtil;

@Service

public class OrderService implements IOrderService{

	@Autowired
	TokenUtil tokenUtil;
	@Autowired
	IUserRepository userRepo;
	@Autowired 
	IBookRepository bookRepo;
	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	MailService mailService;
	
	@Override
	public OrderModel create(OrderDto orderDto) {
		Optional<BookModel> book = bookRepo.findById(orderDto.getBookID());
		
		Optional<UserModel> user = userRepo.findById(orderDto.getUserID());
		if(book.isPresent() && user.isPresent()) {
			if(orderDto.getQuantity() < book.get().getQuantity()) {
				OrderModel newOrder = new OrderModel(orderDto,book.get(),user.get());
				orderRepo.save(newOrder);
				book.get().setQuantity(book.get().getQuantity() - orderDto.getQuantity());
				bookRepo.save(book.get());
				mailService.send(orderDto.getEmail(),"Your Order Placed successfully","Order");

				return newOrder;
			}
		}
		return null;
	}

	@Override
	public List<OrderModel> getOrdersForUser(long id) {
		Optional<UserModel> user = userRepo.findById(id);
		List<OrderModel> ordersList = orderRepo.findAllByUserId(id);
		return ordersList;
	}



}
