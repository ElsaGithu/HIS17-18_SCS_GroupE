package com.his.scs.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import com.his.scs.exceptions.InvalidFormatException;
import com.his.scs.helper.AppConstants;
import com.his.scs.view.PatientDetailsView;

public class PatientDetailsModel {
	private String patientName;
	private int patientAge;
	private int patientWeight;
	private String patientGender;
	private String DoctorName;
	private String contactNumber;
	private String clinicAddress;
	private String emergencyContact;
	private String dateOfLastVisit;
	private JFrame jFrame;

	public void writePatientDetailsToFile(JFrame jFrame, PatientDetailsView theView) 
			throws InvalidFormatException{

		try {
			this.patientName = theView.getNameField().getText().toString();
			this.patientAge = Integer.parseInt(theView.getAgeFieldFormatted().getText());
			this.patientWeight = Integer.parseInt(theView.getWeightFieldFormatted().getText());
			this.patientGender = theView.getGenderCombo().getSelectedItem().toString();
			System.out.println("patientGender::"+ patientGender); 
			this.DoctorName = theView.getDoctorNameField().getText().toString();
			this.contactNumber = theView.getContactNoFormatted().getText().toString();
			this.clinicAddress = theView.getClinicAddressField().getText().toString();
			this.emergencyContact = theView.getEmergencyContactFormatted().getText().toString();
			this.dateOfLastVisit = theView.getDateFormatted().getText().toString();
		}
		catch(Exception e) {
			System.out.println(e);
		}

		this.jFrame = jFrame;
		BufferedWriter out = null;
		try  
		{
			FileWriter fstream = new FileWriter(AppConstants.PATIENT_DETAILS_FILE_PATH, false); //false tells to overwrite data.
			out = new BufferedWriter(fstream);
			out.write(patientName+","+patientAge+","+patientWeight+","+patientGender+","+DoctorName+","+contactNumber+","+clinicAddress+","+emergencyContact+","+dateOfLastVisit+"\n");
		}
		catch (IOException e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		finally
		{
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


	}

}
