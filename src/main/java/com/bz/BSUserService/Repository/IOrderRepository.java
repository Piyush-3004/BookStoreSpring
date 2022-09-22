package com.bz.BSUserService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bz.BSUserService.Model.OrderModel;

public interface IOrderRepository extends JpaRepository<OrderModel,Long>{

	
	List<OrderModel> findAllByUserId(long id);

}
