package com.project.movieticketbooking.exception;

public class BookingDeleteNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public BookingDeleteNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
