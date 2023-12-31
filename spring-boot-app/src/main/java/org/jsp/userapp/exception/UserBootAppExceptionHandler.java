package org.jsp.userapp.exception;

import org.jsp.userapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class UserBootAppExceptionHandler extends  ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFoundException.class)
 public ResponseEntity<ResponseStructure<String>> handleINF(IdNotFoundException exception){
	 ResponseStructure<String> structure = new ResponseStructure<>();
	 structure.setData("User Not Found");
	 structure.setMessage(exception.getMessage());
	 structure.setStatucCode(HttpStatus.NOT_FOUND.value());
	 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
 }
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> handleINF(InvalidCredentialsException exception){
		 ResponseStructure<String> structure = new ResponseStructure<>();
		 structure.setData("User Not Found");
		 structure.setMessage(exception.getMessage());
		 structure.setStatucCode(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	 }
 	
}
