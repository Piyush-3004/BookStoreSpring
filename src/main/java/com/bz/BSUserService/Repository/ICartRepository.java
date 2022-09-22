package com.bz.BSUserService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bz.BSUserService.Model.CartModel;

public interface ICartRepository extends JpaRepository<CartModel ,Long>{

//		@Query("SELECT COUNT(y) FROM CandidateModel y WHERE status =?1")
// Optional<CartModel> findAllByUserId(Integer userID);

//	@Query("SELECT u FROM User u WHERE u.status = ?1")
//	User findUserByStatus(Integer status);
	
	
	@Query(value="select * from cart_model where user_id =:id",nativeQuery=true)
	List<CartModel> findAllByUserId(Long id);

}
