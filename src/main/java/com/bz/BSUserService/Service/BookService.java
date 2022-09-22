package com.bz.BSUserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bz.BSUserService.Dto.BookDto;
import com.bz.BSUserService.Model.BookModel;
import com.bz.BSUserService.Model.UserModel;
import com.bz.BSUserService.Repository.IBookRepository;
import com.bz.BSUserService.Repository.IUserRepository;
import com.bz.BSUserService.Util.TokenUtil;

@Service
public class BookService implements IBookService{

	@Autowired
	IBookRepository bookRepo;
	@Autowired
	TokenUtil tokenUtil;
	@Autowired 
	IUserRepository userRepo;
	@Override
	public BookModel create(BookDto bookDto) {
		BookModel book = new BookModel(bookDto);
		bookRepo.save(book);
		return book;
	}

	@Override
	public List<BookModel> getList() {
		List<BookModel> lst = bookRepo.findAll();
		return lst;
	}

	@Override
	public BookModel update(BookDto bookDto, long id) {
		Optional<BookModel> book = bookRepo.findById(id);
		book.get().setAuthor(bookDto.getAuthor());
		book.get().setDesc(bookDto.getDesc());
		book.get().setLogo(bookDto.getLogo());
		book.get().setName(bookDto.getName());
		book.get().setPrice(bookDto.getPrice());
		book.get().setQuantity(bookDto.getQuantity());
		bookRepo.save(book.get());
		return book.get();
	}

	@Override
	public BookModel delete(long id) {
		Optional<BookModel> book = bookRepo.findById(id);
		bookRepo.delete(book.get());
		return book.get();
	}

	@Override
	public BookModel changeBookPrice(String token, long bookId, Integer newPrice) {
		Long id = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepo.findById(id);
		if(user.isPresent()) {
			Optional<BookModel> book = bookRepo.findById(bookId);
			book.get().setPrice(newPrice);
			bookRepo.save(book.get());
			return book.get();
		}
		return null;
	}

	@Override
	public BookModel changeBookQuantity(String token, long bookId, int quantity) {
		Long id = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepo.findById(id);
		if(user.isPresent()) {
			Optional<BookModel> book = bookRepo.findById(bookId);
			book.get().setQuantity(quantity);
			bookRepo.save(book.get());
			return book.get();
		}
		return null;
	}
	
	

}

