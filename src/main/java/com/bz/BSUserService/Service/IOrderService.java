package com.bz.BSUserService.Service;

import java.util.List;

import com.bz.BSUserService.Dto.OrderDto;
import com.bz.BSUserService.Model.OrderModel;

public interface IOrderService {

	OrderModel create(OrderDto orderDto);

	List<OrderModel> getOrdersForUser(long id);

}
