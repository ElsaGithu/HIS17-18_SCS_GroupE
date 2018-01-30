package com.his.scs.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.his.scs.exceptions.InvalidFormatException;
import com.his.scs.helper.AppConstants;

public class ConfigPatientManualModel {

	private int isModeEnabled;
	private double insulinDose;
	private double glucagonDose;

	public void writeManualModeSettingsToFile(JCheckBox checkBoxValue, JTextField insulinValue, JTextField glucagonValue) 
			throws InvalidFormatException{

		if(checkBoxValue.isSelected()) {
			this.isModeEnabled = 1 ;
		}else {
			this.isModeEnabled = 0 ;
		}


		try {
			this.insulinDose = Double.parseDouble(insulinValue.getText());
			this.glucagonDose = Double.parseDouble(glucagonValue.getText());
		}
		catch(NumberFormatException e) {
			throw new InvalidFormatException("Please give only numbers!!");
		}

		BufferedWriter out = null;
		try  
		{
			FileWriter fstream = new FileWriter(AppConstants.SET_MANUAL_MODE_FILE_PATH, false); //false tells to overwrite data.
			out = new BufferedWriter(fstream);
			out.write(isModeEnabled+","+insulinDose+","+glucagonDose+"\n");
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
