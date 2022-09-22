package com.bz.BSUserService.Service;

import java.util.List;

import com.bz.BSUserService.Dto.UserDto;
import com.bz.BSUserService.Model.UserModel;


public interface IUserService {

	UserModel create(UserDto userDto);

	List<UserModel> getList();

	UserModel update(UserDto userDto, long id);

	UserModel delete(long id);

	String verify(String token);

	UserModel changePassword(String token, String newPassword);

	String forgotPassword(String mail);

	String sendOtp(long id);

	String verifyOtp(String token, long otp);

	String login(String mail, String password);

}
