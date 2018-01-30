package com.his.scs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.his.scs.exceptions.UserInvalidException;
import com.his.scs.model.DoctorVerificationModel;
import com.his.scs.view.DoctorVerificationView;

public class DoctorVerificationController {

	private DoctorVerificationView theView;
	private DoctorVerificationModel theModel;

	public DoctorVerificationController(DoctorVerificationView theView, DoctorVerificationModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theView.verifyUserListener(new UserVerificationListener());

	}

	public DoctorVerificationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	class UserVerificationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String username = "";
			char[] password;

			try {
				username = theView.getUsername_field();
				password = theView.getPassword_field();

				System.out.println("Inside Controller:: User::"+username+"::Password::"+password);

				theView.setValidUser(theModel.verifyUser(username, password));
				System.out.println("Inside Controller. ValidUser boolean value::"+theView.isValidUser());
				theView.setVisible(false);
			}
			catch(UserInvalidException e) {
				theView.displayErrorMessage("ERROR::"+ e);
			}

		}
	}

}
