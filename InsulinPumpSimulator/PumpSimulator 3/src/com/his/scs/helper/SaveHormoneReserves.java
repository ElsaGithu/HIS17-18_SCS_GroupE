package com.his.scs.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveHormoneReserves {
	public void writeToFile(double value,int type) {
		BufferedWriter out = null;
		try  
		{
			FileWriter fstream = new FileWriter(AppConstants.HORMONE_RESERVE_FILE_PATH, false); 
			out = new BufferedWriter(fstream);
			String line="0,0";
			if(type == AppConstants.HORMONE_TYPE_INSULIN) {
				line = (value + ","+AppConstants.getTOTAL_GLUCAGON_USED());
			}
			else {
				line = (AppConstants.getTOTAL_INSULIN_USED()+","+value);
			}
			out.write(line);
			out.close();
		}
		catch (IOException e)
		{
			System.err.println("Error: " + e.getMessage());
		}

	}
	public String readFromFile() {
		BufferedReader buffer = null;
		String hormoneLevels = "";
		FileReader reader = null;
		try {
			reader = new FileReader(AppConstants.HORMONE_RESERVE_FILE_PATH);

			buffer = new BufferedReader(reader);

			hormoneLevels = buffer.readLine();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hormoneLevels;
	}


}
