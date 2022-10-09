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
import com.app.library.exception.LibraryException;
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
	public List<Book> getBooksByAuthorId(final String authorId) {
		return bookDAO.findBooksByAuthorId(authorId);
	}

	@Override
	public Book getBookById(final String bookId) {
		Optional<Book> book = bookDAO.findById(bookId);
		if (book.isEmpty()) {
			LibraryException.validationFailure("No book record present for bookId: " + bookId);
		}
		return book.get();
	}

	@Override
	public Book addBook(final BookInputModel bookInputModel) {
		final Book book = new Book();
		book.setAuthors(bookInputModel.getAuthors());
		book.setBookId(bookInputModel.getBookId());
		book.setBookName(bookInputModel.getBookName());
		return bookDAO.save(book);
	}

	@Override
	public Book updateBookName(final BookInputModel input) {
		final Optional<Book> book = bookDAO.findById(input.getBookId());
		if (book.isEmpty()) {
			LibraryException.validationFailure("No book record present for bookId: " + input.getBookId());
		}
		book.get().setBookName(input.getBookName());
		return bookDAO.save(book.get());
	}

	@Override
	public Book updateBookAuthorList(final BookInputModel input) {
		final Optional<Book> book = bookDAO.findById(input.getBookId());
		if (book.isEmpty()) {
			LibraryException.validationFailure("No book record present for bookId: " + input.getBookId());
		}
		book.get().setAuthors(input.getAuthors());
		return bookDAO.save(book.get());
	}

	@Override
	public void deleteBookById(final String bookId) {
		bookDAO.deleteById(bookId);
	}

}