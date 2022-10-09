/**
 * 
 */
package com.app.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.app.library.dao.UserDAO;
import com.app.library.entity.User;
import com.app.library.exception.LibraryException;
import com.app.library.model.SessionUser;

/**
 * @author Sunil.Chauhan
 *
 */
@Component
public class BasicAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserDAO userDAO;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		String userName = authToken.getPrincipal().toString();
		String password = authToken.getCredentials().toString();
		Optional<User> user = userDAO.findById(userName);
		if (user.isEmpty() || password.equals("Pass@123")) {
			LibraryException.unauthorized();
		}
		SessionUser sessionUser = getSessionUser(user);
		return new UsernamePasswordAuthenticationToken(sessionUser, null,
				sessionUser.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	}

	private SessionUser getSessionUser(Optional<User> user) {
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUserId(user.get().getUserId());
		sessionUser.setUserName(user.get().getUserName());
		List<String> roles = new ArrayList<>();
		roles.add(user.get().getUserRole());
		sessionUser.setRoles(roles);
		return sessionUser;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
	}

}
