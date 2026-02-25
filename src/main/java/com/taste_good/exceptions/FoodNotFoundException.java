package com.taste_good.exceptions;

public class FoodNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6990191189911329665L;

	public FoodNotFoundException(String message) {
		super(message);
	}

}
