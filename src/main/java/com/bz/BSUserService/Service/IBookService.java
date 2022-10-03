package com.bz.BSUserService.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bz.BSUserService.Dto.BookDto;
import com.bz.BSUserService.Model.BookModel;

public interface IBookService {

	BookModel create(BookDto bookDto);

	List<BookModel> getList();

	BookModel update(BookDto bookDto, long id);

	BookModel delete(long id);

	BookModel changeBookPrice(String token, long bookId, Integer newPrice);

	BookModel changeBookQuantity(String token, long bookId, int quantity);

	int getBookCount();

	String setLogo(long bookId, MultipartFile profilePic) throws IOException;

}
