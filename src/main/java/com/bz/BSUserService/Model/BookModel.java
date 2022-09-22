package com.bz.BSUserService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.bz.BSUserService.Dto.BookDto;

import lombok.Data;

@Entity
@Data
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    @Column(name="bookname") 
	private String name;
    @Column(name="bookauthor") 
	private String author;
    @Column(name="bookdesc") 
	private String desc;
    @Column(name="bookogo") 
	private String logo;
    @Column(name="bookprice") 
	private Integer price;
    @Column(name="bookquantity") 
	private int quantity;
	
	public BookModel(BookDto bookDto) {
	
		this.name=bookDto.getName();
		this.author=bookDto.getAuthor();
		this.desc=bookDto.getDesc();
		this.logo=bookDto.getLogo();
		this.price=bookDto.getPrice();
		this.quantity=bookDto.getQuantity();
				
	}

	public BookModel() {
		super();
	}
	
}
