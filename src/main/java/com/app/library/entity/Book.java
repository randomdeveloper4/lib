/**
 * 
 */
package com.app.library.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Sunil.Chauhan
 *
 */
@Entity
@Data
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "book_id")
	private String bookId;

	@Column(name = "book_name")
	private String bookName;

	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private Set<Author> authors;

}