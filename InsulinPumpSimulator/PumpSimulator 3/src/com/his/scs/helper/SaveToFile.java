package com.his.scs.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SaveToFile{

	/**
	 * 
	 */
	private static final long serialVersionUID = -969381562355628665L;
	private double bsl;
	private double insulinValue;
	private double glucagonValue;
	private JFrame jFrame;

	public SaveToFile() {
		super();
	}

	public SaveToFile(double bsl, double insulin, double glucagon) {
		this.bsl = bsl;
		this.insulinValue = insulin;
		this.glucagonValue = glucagon;

		initialize();
	}
	private void initialize() {

		writePatientHistoryToFile();
	}

	public void writePatientHistoryToFile() {
		BufferedWriter out = null;
		try  
		{
			FileWriter fstream = new FileWriter(AppConstants.PATIENT_HISTORY_FILE_PATH, true); //true tells to append data.
			out = new BufferedWriter(fstream);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String dateTime = (dateFormat.format(date));

			out.write(dateTime+","+bsl+","+insulinValue+","+glucagonValue+"\n");
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
