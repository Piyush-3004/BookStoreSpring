package com.bz.BSUserService.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.Data;

@Data
public class UserDto {

	private String firstName;
	private String lastName;
	private String kyc;
	private LocalDate dob; 
	private String password;
	private String email;
	private LocalDate purchaseDate;
	private LocalDate expiryDate;

}
