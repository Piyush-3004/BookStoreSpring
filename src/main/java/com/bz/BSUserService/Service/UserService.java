package com.bz.BSUserService.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bz.BSUserService.Dto.UserDto;
import com.bz.BSUserService.Model.UserModel;
import com.bz.BSUserService.Repository.IUserRepository;
import com.bz.BSUserService.Util.TokenUtil;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepo;
	@Autowired
	MailService mailService;
	@Autowired
	TokenUtil tokenUtil;

	@Override
	public UserModel create(UserDto userDto) {
		UserModel user = new UserModel(userDto); 
		userRepo.save(user);
		
		String token = tokenUtil.createToken(user.getId());

		String subject="User Registration Succesfull";
		String body = "http://localhost:9090/bookstore/verify/"+token;
		mailService.send(user.getEmail(),subject,body);
		return user;
	}

	@Override
	public List<UserModel> getList() {
		List<UserModel> list = userRepo.findAll();
		return list;
	}

	@Override
	public UserModel update(UserDto userDto , long id) {
		Optional<UserModel> user = userRepo.findById(id);
		user.get().setFirstName(userDto.getFirstName());
		user.get().setLastName(userDto.getLastName());
		user.get().setKyc(userDto.getKyc());
		user.get().setDob(userDto.getDob());
		user.get().setPassword(userDto.getPassword());
		user.get().setEmail(userDto.getEmail());
		user.get().setPurchaseDate(userDto.getPurchaseDate());
		user.get().setExpiryDate(userDto.getExpiryDate());
		userRepo.save(user.get());
		return user.get();
	}

	@Override
	public UserModel delete(long id) {
		Optional<UserModel> user = userRepo.findById(id);
		userRepo.delete(user.get());
		return user.get();
	}

	
	@Override
	public String verify(String token) {
		Long id = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepo.findById(id);
		if(user.isPresent()) {
		user.get().setVerify(true);
		userRepo.save(user.get());
		}
		return "Verified";
	}
	@Override
	public String forgotPassword(String mail) {
		Optional<UserModel> user = userRepo.findByEmail(mail);	
		String token = tokenUtil.createToken(user.get().getId());
		String url ="http://localhost:9090/bookstore/changepassword/newpasswordhere";
		String subject="Reset password";
		String body="Link: "+url+"/"+token+"?newPassword=desiredpasswordhere"+"\n token in pathvariable and newpassword is requestparam";	
		mailService.send(user.get().getEmail(), subject, body);
		return "Mail Sent Successfully....!!!";
	}

	@Override
	public UserModel changePassword(String token,String newPassword) {
		long id = tokenUtil.decodeToken(token);
		Optional<UserModel> isUserPresent = userRepo.findById(id);
		isUserPresent.get().setPassword(newPassword);
		userRepo.save(isUserPresent.get());
		return isUserPresent.get();
	}

	
	
	@Override
	public String sendOtp(long id) {
		Optional<UserModel> isUserPresent = userRepo.findById(id);		
		Random otp = new Random();
	    int number = otp.nextInt(999999);
	    isUserPresent.get().setOtp(number);
	    userRepo.save(isUserPresent.get());
	    String subject="OTP";
		String body="OTP is :"+number;		
		mailService.send(isUserPresent.get().getEmail(), subject, body);
		return "Otp sent on mail";
	}

	@Override
	public String verifyOtp(String token, long otp) {
		Long id = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepo.findById(id);
		long dbOtp = user.get().getOtp();
		if(dbOtp==otp) {
			return "Otp Verified";
		}
		return "Wrong Otp";
	}

	@Override
	public String login(String mail,String password) {

		Optional<UserModel> user = userRepo.findByEmail(mail);
		String token = "";
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				token = tokenUtil.createToken(user.get().getId());
			}
			
		}
		return token;
	}

}
