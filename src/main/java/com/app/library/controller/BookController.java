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
import com.app.library.model.BookUpdateInputModel;
import com.app.library.service.BookService;

/**
 * @author Sunil.Chauhan
 *
 */
@RestController
@RequestMapping("/book/")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("get/books/{authorName}")
	public List<Book> getBooksByAuthor(@PathVariable final String author) {
		return bookService.getBooksByAuthor(author);
	}
	
	@GetMapping("get/book/{bookId}")
	public Book getBook(@PathVariable final String bookId) {
		return bookService.getBook(bookId);
	}
	
	@PostMapping("add/book")
	public Book addBook(@RequestBody final Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("update/bookName")
	public Book updateBookName(@RequestBody final BookUpdateInputModel input) {
		return bookService.updateBookName(input);
	}
	
	@PutMapping("update/bookAuthorList")
	public Book updateBookAuthorList(@RequestBody final BookUpdateInputModel input) {
		return bookService.updateBookAuthorList(input);
	}
	
	@DeleteMapping("delete/book")
	public void delete(@RequestBody final Book book) {
		bookService.deleteBook(book);
	}

}