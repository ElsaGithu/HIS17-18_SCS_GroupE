package com.his.scs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.his.scs.exceptions.InvalidFormatException;
import com.his.scs.model.PatientDetailsModel;
import com.his.scs.view.PatientDetailsView;

public class PatientDetailsController {

	private PatientDetailsView theView;
	private PatientDetailsModel theModel;

	public PatientDetailsController(PatientDetailsView theView, PatientDetailsModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.SaveDetailsListener(new SavePatientDetailsListener());
	}

	class SavePatientDetailsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Inside SavePatientDetailsListener of controller");
			try {
				theModel.writePatientDetailsToFile(theView,theView);
				theView.displaySuccessMessage("Saved Details");
			}
			catch(InvalidFormatException e) {
				theView.displayErrorMessage("ERROR::"+ e);
			}

		}
	}	

}
