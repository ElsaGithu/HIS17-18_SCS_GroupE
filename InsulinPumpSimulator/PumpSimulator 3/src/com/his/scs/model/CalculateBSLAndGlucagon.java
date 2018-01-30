package com.his.scs.model;
import java.util.ArrayList;

import com.his.scs.helper.AppConstants;

public class CalculateBSLAndGlucagon {

	private double glucagon;
	private ArrayList<Double> bslList = new ArrayList<Double>();
	private double finalValue = AppConstants.BSL_SAFE;

	public double calculateGlucagon(double bslValue) {


		glucagon=(((AppConstants.BSL_SAFE-bslValue)/AppConstants.TIME_DURATION_IN_MINUTES_GLUCAGON)+
				(AppConstants.K_OUT_G*bslValue))/**Math.pow(10, -9)*/;
		return glucagon;

	}

	public ArrayList<Double> addBSLValuesToList(double bslValue) {
		int count=0;
		double value = bslValue;
		do {
			value+= (AppConstants.K_IN_G*(glucagon/1000)) - (AppConstants.K_OUT_G * value) + 0.012;
			count++;
			bslList.add(value);
		} while (value <= finalValue && count < 500);

		return bslList;
	}
	public double calculateFinalLevelFromGlucagonDosage() {

		finalValue = (-(AppConstants.BSL_PREVIOUS * AppConstants.K_OUT_G) +
				(glucagon)+
				(AppConstants.BSL_PREVIOUS/AppConstants.TIME_DURATION_IN_MINUTES_GLUCAGON) )*AppConstants.TIME_DURATION_IN_MINUTES_INSULIN;
		return finalValue;
	}

	public double getGlucagon() {
		return glucagon;
	}

	public void setGlucagon(double glucagon) {
		this.glucagon = glucagon;
	}

}
