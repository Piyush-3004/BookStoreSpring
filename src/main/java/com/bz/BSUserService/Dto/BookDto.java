package com.bz.BSUserService.Dto;


import lombok.Data;


@Data
public class BookDto {
	
	private String name;
	private String author;
	private String desc;
	private Integer price;
	private Integer quantity;

}
