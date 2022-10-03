package com.bz.BSUserService.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.multipart.MultipartFile;

import com.bz.BSUserService.Dto.BookDto;
import com.bz.BSUserService.Model.BookModel;
import com.bz.BSUserService.Service.IBookService;

@CrossOrigin(origins = "http://localhost:3000/")

@RestController
@RequestMapping("/bookstore/book")
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@PostMapping("/create")
	public BookModel create(@RequestBody BookDto bookDto) {
		return bookService.create(bookDto);
	}
	
	@GetMapping("/getlist")
	public List<BookModel> getList(){
		return bookService.getList();
	}
	
	@PostMapping("/setlogo/{bookId}")
	public String setLogo(@RequestParam MultipartFile profilePic,@PathVariable long bookId) throws IOException {
		return bookService.setLogo(bookId,profilePic);
	}
	
	@PutMapping("/update/{id}")
	public BookModel update(@RequestBody BookDto bookDto,@PathVariable long id) {
		return bookService.update(bookDto,id);
	}
		
	@DeleteMapping("/delete/{id}")
	public BookModel delete(@PathVariable long id) {
		return bookService.delete(id);
	}
	
	@PutMapping("/changebookprice/{bookId}/{newPrice}")
	public BookModel changeBookPrice(@RequestHeader String token,@PathVariable long bookId,@PathVariable Integer newPrice) {
		return bookService.changeBookPrice(token,bookId,newPrice);
	}
	
	@PutMapping("/changebookquantity/{bookId}/{quantity}")
	public BookModel changeBookQuantity(@RequestHeader String token,@PathVariable long bookId,@PathVariable int quantity) {
		return bookService.changeBookQuantity(token,bookId,quantity);
	}
	
	@GetMapping("/getbookscount")
	public int getBookCount() {
		return bookService.getBookCount();
	}
}
