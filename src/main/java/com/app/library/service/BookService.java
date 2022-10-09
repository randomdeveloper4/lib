/**
 * 
 */
package com.app.library.service;

import java.util.List;

import com.app.library.entity.Book;
import com.app.library.model.BookInputModel;

/**
 * @author Sunil.Chauhan
 *
 */
public interface BookService {

	List<Book> getBooksByAuthorId(final String authorId);

	Book getBookById(final String bookId);

	Book addBook(final BookInputModel book);

	Book updateBookName(final BookInputModel bookName);

	Book updateBookAuthorList(final BookInputModel input);

	void deleteBookById(final String bookId);

}
