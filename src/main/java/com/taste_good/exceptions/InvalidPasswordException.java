package com.taste_good.exceptions;

public class InvalidPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6814813176958819828L;

	public InvalidPasswordException(String message) {
		super(message);
	}
}
