package com.his.scs.model;

import java.util.Arrays;

import com.his.scs.exceptions.UserInvalidException;

public class DoctorVerificationModel {

	public boolean verifyUser(String username, char[] password) throws UserInvalidException {
		System.out.println("Inside Verify User model");
		String dUser = "doctor";
		char[] dPass = new char[]{'p','a','s','s','1','2','3'};
		boolean validUser = false;
		if(username.equals(dUser)) {
			if(Arrays.equals(dPass, password)) {
				System.out.println("If username and password matches.");
				validUser = true;
			}
			else {
				throw new UserInvalidException("Invalid Password!");
			}
		}
		else {
			throw new UserInvalidException("Invalid Username!");
		}
		System.out.println("above return validUser");
		return validUser;
	}

}
