package com.example.JobTracker;

public class JobNotFoundException extends RuntimeException {

	JobNotFoundException(Long id){
		super("Could not find Job " + id);
	}
	
}
