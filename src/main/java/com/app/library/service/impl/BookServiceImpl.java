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
import com.app.library.model.BookInputModel;
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
	public List<Book> getBooksByAuthor(String authorId) {
		List<Book> books = bookDAO.findBooksByAuthorId(authorId);
		return books;
	}

	@Override
	public Book getBook(String bookId) {
		Optional<Book> book = bookDAO.findById(bookId);
		return book.get();
	}

	@Override
	public Book addBook(BookInputModel bookInputModel) {
		Book book = new Book();
		book.setAuthors(bookInputModel.getAuthors());
		book.setBookId(bookInputModel.getBookId());
		book.setBookName(bookInputModel.getBookName());
		return bookDAO.save(book);
	}

	@Override
	public Book updateBookName(BookInputModel input) {
		final Optional<Book> book = bookDAO.findById(input.getBookId());
		book.get().setBookName(input.getBookName());
		return bookDAO.save(book.get());
	}

	@Override
	public Book updateBookAuthorList(BookInputModel input) {
		final Optional<Book> book = bookDAO.findById(input.getBookId());
		book.get().setAuthors(input.getAuthors());
		return bookDAO.save(book.get());
	}

	@Override
	public void deleteBook(String bookId) {
		bookDAO.deleteById(bookId);
	}

}
