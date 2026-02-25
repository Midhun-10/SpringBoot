package com.taste_good.exceptions;

public class HotelNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7324536935851600180L;

	public HotelNotFoundException(String message) {
		super(message);
	}

}
