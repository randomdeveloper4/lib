/**
 * 
 */
package com.app.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.library.entity.User;

/**
 * @author Sunil.Chauhan
 *
 */
public interface UserDAO extends JpaRepository<User, String> {

}
