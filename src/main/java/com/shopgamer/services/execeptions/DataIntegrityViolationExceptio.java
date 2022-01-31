package com.shopgamer.services.execeptions;

public class DataIntegrityViolationExceptio extends RuntimeException{

	private static final long serialVersionUID = 1L; 
	
	public DataIntegrityViolationExceptio(String msg) {
		super(msg);
	}
	
	public DataIntegrityViolationExceptio(String msg, Throwable cause) {
		super(msg, cause);
	}

}
 