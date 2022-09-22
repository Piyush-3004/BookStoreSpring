package com.bz.BSUserService.Dto;

import javax.persistence.OneToOne;

import com.bz.BSUserService.Model.BookModel;
import com.bz.BSUserService.Model.UserModel;

import lombok.Data;

@Data
public class OrderDto {
    private Integer quantity;
    private String address;
    private Integer price;
    private Long userID;
    private String email;
    private Long bookID;
    private boolean cancel;
}
