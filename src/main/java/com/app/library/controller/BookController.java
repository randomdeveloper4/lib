/**
 * 
 */
package com.app.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/getBooksByAuthorId/{authorId}")
	@PreAuthorize("hasRole('USER')")
	public List<Book> getBooksByAuthorId(@PathVariable final String authorId) {
		return bookService.getBooksByAuthorId(authorId);
	}

	@GetMapping("/getBookById/{bookId}")
	@PreAuthorize("hasRole('USER')")
	public Book getBookById(@PathVariable final String bookId) {
		return bookService.getBookById(bookId);
	}

	@PostMapping("/addBook")
	@PreAuthorize("hasRole('USER')")
	public Book addBook(@RequestBody final BookInputModel book) {
		return bookService.addBook(book);
	}

	@PutMapping("/updateBookName")
	@Secured("USER")
	public Book updateBookName(@RequestBody final BookInputModel input) {
		return bookService.updateBookName(input);
	}

	@PutMapping("/updateBookAuthorList")
	@Secured("ADMIN")
	public Book updateBookAuthorList(@RequestBody final BookInputModel input) {
		return bookService.updateBookAuthorList(input);
	}

	@DeleteMapping("/deleteBookById")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteBookById(@RequestBody final String bookId) {
		bookService.deleteBookById(bookId);
	}

}