package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

//	Generic Exception Handling
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> GenericExceptionHandler(Exception ex, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		return rs;
	}

//	No handler Found Exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NohandlerFoundExceptionHandler(NoHandlerFoundException nf, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nf.getMessage(), req.getDescription(false));

		ResponseEntity<MyErrorDetails> rs = new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

		return rs;

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException mv) {
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
				
				mv.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

//	Application specific Exception Handler 
	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(SomethingWentWrongException sm, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), sm.getMessage(), req.getDescription(false));

		ResponseEntity<MyErrorDetails> re = new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
		return re;
	}

//	Application specific Exception Handler 
	@ExceptionHandler(UserExceptions.class)
	public ResponseEntity<MyErrorDetails> UserExceptionHandler(UserExceptions ue, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ue.getMessage(), req.getDescription(false));

		ResponseEntity<MyErrorDetails> re = new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
		return re;
	}

}
