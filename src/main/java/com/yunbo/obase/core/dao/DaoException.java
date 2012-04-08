package com.yunbo.obase.core.dao;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5974347342508102190L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
}
