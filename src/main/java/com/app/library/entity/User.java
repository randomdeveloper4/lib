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
@Table(name="user")
@Data
public class User {
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_role")
	private String userRole;

}