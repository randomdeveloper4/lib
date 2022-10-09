/**
 * 
 */
package com.app.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.library.dao.BookDAO;
import com.app.library.entity.Book;
import com.app.library.model.BookUpdateInputModel;
import com.app.library.service.BookService;

/**
 * @author Sunil.Chauhan
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;

	@Override
	public List<Book> getBooksByAuthor(String author) {
		List<Book> books = bookDAO.findByAuthors(author);
		return books;
	}

	@Override
	public Book getBook(String bookId) {
		Optional<Book> book = bookDAO.findById(bookId);
		return book.get();
	}

	@Override
	public Book addBook(Book book) {
		Book newBook = bookDAO.save(book);
		return newBook;
	}

	@Override
	public Book updateBookName(BookUpdateInputModel input) {
		final Optional<Book> book = bookDAO.findById(input.getBookId());
		book.get().setBookName(input.getUpdatedBookName());
		return bookDAO.save(book.get());
	}

	@Override
	public Book updateBookAuthorList(BookUpdateInputModel input) {
		final Optional<Book> book = bookDAO.findById(input.getBookId());
//		book.get().setAuthors(input.getUpdatedAuthors().);
		return bookDAO.save(book.get());
	}

	@Override
	public void deleteBook(Book book) {
		bookDAO.delete(book);
	}

}
