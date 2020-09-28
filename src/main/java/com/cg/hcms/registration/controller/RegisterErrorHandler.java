package com.cg.hcms.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcms.registration.exception.ContactNumberAlreadyExistException;
import com.cg.hcms.registration.exception.EmailAlreadyExistException;
import com.cg.hcms.registration.exception.UserNameAlreadyExistException;
import com.cg.hcms.registration.exception.UserNotFoundException;



@RestController
@ControllerAdvice
public class RegisterErrorHandler {

	//TO handle User Name Already Exception
	@ExceptionHandler(UserNameAlreadyExistException.class)
	public ResponseEntity<?> handleUserNameAlreadyExistException(UserNameAlreadyExistException exception)
	{
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
	}
	
	//TO handle ContactNumber Already Exception
	@ExceptionHandler(ContactNumberAlreadyExistException.class)
	public ResponseEntity<?> handleContactNumberAlreadyExistException(ContactNumberAlreadyExistException exception)
	{
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
	}
	
	//TO handle Email Already Exception
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<?> handleEmailAlreadyExistException(EmailAlreadyExistException exception)
	{
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
	}
	
	//TO handle UserNotFound Exception
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}

