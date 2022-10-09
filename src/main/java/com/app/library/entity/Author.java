/**
 * 
 */
package com.app.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Sunil.Chauhan
 *
 */
@Entity
@Table(name="author")
@Data
public class Author {

	@Id
	@Column(name="author_id")
	private String authorId;
	
	@Column(name="author_name")
	private String authorName;
	
}