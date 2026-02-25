package com.taste_good.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -852268296277358597L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
