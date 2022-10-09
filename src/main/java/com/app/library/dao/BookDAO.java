/**
 * 
 */
package com.app.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.library.entity.Book;

/**
 * @author Sunil.Chauhan
 */
@Repository
public interface BookDAO extends JpaRepository<Book, String>{

	@Query("SELECT b FROM Book b JOIN b.authors a WHERE a.authorId = ?1")
	List<Book> findBooksByAuthorId(String authorId);

}