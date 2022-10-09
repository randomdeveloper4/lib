/**
 * 
 */
package com.app.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.library.entity.Book;

/**
 * @author Sunil.Chauhan
 *
 */
@Repository
public interface BookDAO extends JpaRepository<Book, String>{

	List<Book> findByAuthors(String author);

}
