/**
 * 
 */
package com.app.library.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author Sunil.Chauhan
 *
 */
@Data
public class SessionUser implements Serializable {

	private static final long serialVersionUID = 1000L;

	private String userId;

	private String userName;

	private List<String> roles;
}