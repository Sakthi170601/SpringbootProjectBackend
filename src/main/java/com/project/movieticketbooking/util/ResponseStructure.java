package com.project.movieticketbooking.util;

public class ResponseStructure<T> {

	private T Data;
	private String message;
	private int statusCode;

	public ResponseStructure(T data, String message, int statusCode) {
		super();
		Data = data;
		this.message = message;
		this.statusCode = statusCode;
	}

	public ResponseStructure() {
		super();
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResponseStructure [Data=" + Data + ", message=" + message + ", statusCode=" + statusCode + "]";
	}

}
