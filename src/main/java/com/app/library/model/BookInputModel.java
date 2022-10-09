/**
 * 
 */
package com.app.library.model;

import java.util.Set;

import com.app.library.entity.Author;

import lombok.Data;

/**
 * @author Sunil.Chauhan
 *
 */
@Data
public class BookInputModel {
	
	private String bookId;

	private String bookName;
	
	private Set<Author> authors;
}