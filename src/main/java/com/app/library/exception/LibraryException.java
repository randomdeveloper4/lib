/**
 * 
 */
package com.app.library.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Sunil.Chauhan
 *
 */
public class LibraryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public String message;

	public String briefMessage;

	public HttpStatus status;

	public LibraryException(String message, HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}

	public LibraryException(String message, String briefMessage, HttpStatus status, Throwable error) {
		super(message, error);
		this.message = message;
		this.status = status;
		this.briefMessage = briefMessage;
	}

	public String getMessage() {
		return this.message;
	}

	public String getBriefMessage() {
		return this.briefMessage;
	}
	
	public HttpStatus getStatus() {
		return this.status;
	}

	public static LibraryException validationFailure(String message) {
		throw new LibraryException(message, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	public static LibraryException validationFailure(String message, String briefMessage, Throwable error) {
		throw new LibraryException(message, briefMessage, HttpStatus.UNPROCESSABLE_ENTITY, error);
	}

	public static LibraryException systemFailure(String message) {
		throw new LibraryException(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static LibraryException systemFailure(String message, String briefMessage, Throwable error) {
		throw new LibraryException(message, briefMessage, HttpStatus.INTERNAL_SERVER_ERROR, error);
	}

	public static LibraryException dataNotFoundFailure(String message) {
		throw new LibraryException(message, HttpStatus.NOT_FOUND);
	}

	public static LibraryException dataNotFoundFailure(String message, String briefMessage, Throwable error) {
		throw new LibraryException(message, briefMessage, HttpStatus.NOT_FOUND, error);
	}

	public static LibraryException unauthorized() {
		throw new LibraryException("User is not authorized to acces this resource.",
				HttpStatus.UNAUTHORIZED);
	}

	public static LibraryException unauthorized(String message, String briefMessage, Throwable error) {
		throw new LibraryException(message == null ? "User is not authorized to acces this resource." : message,
				briefMessage, HttpStatus.UNAUTHORIZED, error);
	}
}
