/**
 * 
 */
package com.app.library.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Sunil.Chauhan
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LibraryException.class)
	public ResponseEntity<Object> wmExceptionHandler(HttpServletRequest req, final LibraryException e) {
		final Map<String, Object> map = new HashMap<>();
		map.put("Error Message", e.getMessage());
		map.put("Brief Error Message", e.getBriefMessage() != null ? e.getBriefMessage() : "NA");
		map.put("Error Code", e.getStatus().value() + ":" + e.getStatus().name());
		map.put("Error Time Stamp", Instant.now().toString());
		map.put("Api Endpoint", req.getRequestURI());
		map.put("Http Method", req.getMethod());
		e.printStackTrace();
		return ResponseEntity.status(e.getStatus()).body(map);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> genericExceptionHandler(HttpServletRequest req, final Exception e) {
		final Map<String, Object> map = new HashMap<>();
		map.put("Error Message", e.getMessage());
		map.put("Error Code", "500:Internal Server Error");
		map.put("Error Time Stamp", Instant.now().toString());
		map.put("Api Endpoint", req.getRequestURI());
		map.put("Http Method", req.getMethod());
		e.printStackTrace();
		return ResponseEntity.status(500).body(map);
	}

}
