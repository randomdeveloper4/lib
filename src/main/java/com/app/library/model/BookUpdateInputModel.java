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
public class BookUpdateInputModel {
	
	private String bookId;

	private String updatedBookName;
	
	private Set<Author> updatedAuthors;
}