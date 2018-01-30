package com.his.scs.exceptions;

public class InvalidFormatException extends Exception{
	String message = "";

	public InvalidFormatException(String message){
		this.message = message;
	}

	@Override
	public String toString() { 
		System.out.println(message);
		return (message);
	}
}
