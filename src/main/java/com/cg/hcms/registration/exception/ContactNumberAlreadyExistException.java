package com.cg.hcms.registration.exception;

public class ContactNumberAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ContactNumberAlreadyExistException(String message)
	{
		super(message);
	}
	public ContactNumberAlreadyExistException()
	{
		super();
	}
}

