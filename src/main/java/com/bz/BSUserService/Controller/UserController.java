package com.bz.BSUserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bz.BSUserService.Dto.UserDto;
import com.bz.BSUserService.Model.UserModel;
import com.bz.BSUserService.Service.IUserService;



@RestController
@RequestMapping("/bookstore")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/create")
	public UserModel create(@RequestBody UserDto userDto) {
		return userService.create(userDto);
	}
	
	@GetMapping("/getlist")
	public List<UserModel> getList(){
		return userService.getList();
	}
	
	@PutMapping("/update/{id}")
	public UserModel update(@RequestBody UserDto userDto , @PathVariable long id) {
		return userService.update(userDto,id);
	}

	@DeleteMapping("/delete/{id}")
	public UserModel delete(@PathVariable long id) {
		return userService.delete(id);
		
	}
	
	@GetMapping("/login/{mail}/{password}")
	public String login(@PathVariable String mail,@PathVariable String password) {
		return userService.login(mail,password);
	}
	
	@PutMapping("/verify/{token}")
	public String verify(@PathVariable String token) {
		return userService.verify(token);
	}
	
	@PostMapping("/forgetpassword/{mail}")
	public String forgotPassword(@PathVariable String mail) {
		return userService.forgotPassword(mail);
	}
	
	@PostMapping("/resetpassword/{token}")
	public UserModel changePassword(@PathVariable String token,@RequestParam String newPassword) {
		return userService.changePassword(token,newPassword);
	}
	
	@PutMapping("/sendotp/{id}")
	public String sendOtp(@PathVariable long id) {
		return userService.sendOtp(id);
		
	}
	@GetMapping("/verifyotp/{otp}")
	public String verifyOtp(@RequestHeader String token,@PathVariable long otp) {
		return userService.verifyOtp(token,otp);
	}
	
}
