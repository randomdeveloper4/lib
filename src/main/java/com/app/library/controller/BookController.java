/**
 * 
 */
package com.app.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.library.entity.Book;
import com.app.library.model.BookInputModel;
import com.app.library.service.BookService;

/**
 * @author Sunil.Chauhan
 */
@RestController
@RequestMapping("/book/")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("get/books/{authorId}")
	public List<Book> getBooksByAuthor(@PathVariable final String authorId) {
		return bookService.getBooksByAuthor(authorId);
	}
	
	@GetMapping("get/book/{bookId}")
	public Book getBook(@PathVariable final String bookId) {
		return bookService.getBook(bookId);
	}
	
	@PostMapping("add/book")
	public Book addBook(@RequestBody final BookInputModel book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("update/bookName")
	public Book updateBookName(@RequestBody final BookInputModel input) {
		return bookService.updateBookName(input);
	}
	
	@PutMapping("update/bookAuthorList")
	public Book updateBookAuthorList(@RequestBody final BookInputModel input) {
		return bookService.updateBookAuthorList(input);
	}
	
	@DeleteMapping("delete/book")
	public void delete(@RequestBody final String bookId) {
		bookService.deleteBook(bookId);
	}

}