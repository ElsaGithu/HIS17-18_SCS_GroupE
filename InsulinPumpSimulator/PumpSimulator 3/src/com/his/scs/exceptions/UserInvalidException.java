package com.his.scs.exceptions;

public class UserInvalidException extends Exception{
	String message = "";
	
	public UserInvalidException(String message){
		this.message = message;
	}
	
	 @Override
	   public String toString() { 
		 System.out.println(message);
	      return (message);
	   }
}
