package com.bz.BSUserService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bz.BSUserService.Model.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, Long>{

	Optional<UserModel> findByEmail(String mail);

}
