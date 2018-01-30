package com.his.scs.exceptions;

public class UserExistsException extends Exception{
	String message = "";
	
	public UserExistsException(String message){
		this.message = message;
	}
	
	 @Override
	   public String toString() { 
		 System.out.println(message);
	      return (message);
	   }

}
