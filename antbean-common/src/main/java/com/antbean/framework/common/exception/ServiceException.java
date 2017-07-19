package com.antbean.framework.common.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	protected static final int DEFAULT_CODE = 200;
	protected int code = DEFAULT_CODE;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(int code) {
		super();
		this.code = code;
	}

	public ServiceException(String message, int code) {
		super(message);
		this.code = code;
	}

	public ServiceException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}

	public ServiceException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
