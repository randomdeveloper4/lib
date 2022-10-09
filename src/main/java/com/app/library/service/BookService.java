/**
 * 
 */
package com.app.library.service;

import java.util.List;

import com.app.library.entity.Book;
import com.app.library.model.BookUpdateInputModel;

/**
 * @author Sunil.Chauhan
 *
 */
public interface BookService {
	
	List<Book> getBooksByAuthor(final String author);

	Book getBook(final String bookId);

	Book addBook(final Book book);

	Book updateBookName(final BookUpdateInputModel bookName);
	
	Book updateBookAuthorList(final BookUpdateInputModel input);

	void deleteBook(final Book book);

}
