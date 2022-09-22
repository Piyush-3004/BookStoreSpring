package com.bz.BSUserService.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.bz.BSUserService.Dto.UserDto;

import lombok.Data;

@Data
@Entity
public class UserModel {

//	Id - Long ✔️
//	First name - String ✔️
//	Last name - String ✔️
//	Kyc - String ✔️
//	Dob - LocalDate ✔️
//	Registered date - LocalDate ✔️
//	updated date - LocalDate ✔️
//	Password - String ✔️ (passwordencoder)
//	Email Id - String ✔️
//	Boolean Verify ✔️
//	Otp-6 digit
//	Purchase Date - LocalDate ✔️
//	Expiry Date - LocalDate ✔️

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String kyc;
	private LocalDate dob;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp	
	private LocalDateTime updatedAt;
	private String password;
	private String email;
	private boolean verify;
	private long otp; 
	private boolean isDeleted;
	private LocalDate purchaseDate;
	private LocalDate expiryDate;

	
	public UserModel(UserDto userDto) {
		this.firstName=userDto.getFirstName();
		this.lastName=userDto.getLastName();
		this.kyc=userDto.getKyc();
		this.dob=userDto.getDob();
		this.password=userDto.getPassword();
		this.email=userDto.getEmail();
		this.purchaseDate=userDto.getPurchaseDate();
		this.expiryDate=userDto.getExpiryDate();
		
	}

	public UserModel() {
		super();
	}
	
	
}
