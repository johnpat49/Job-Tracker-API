package com.example.JobTracker;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Renders a 404 response when Job not found exception is thrown
 * @author Owner
 *
 */
@ControllerAdvice
public class JobNotFoundAdvice {

	  @ResponseBody
	  @ExceptionHandler(JobNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(JobNotFoundException ex) {
	    return ex.getMessage();
	  }
	
}
