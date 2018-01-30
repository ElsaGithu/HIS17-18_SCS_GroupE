package com.his.scs.model;
import java.util.ArrayList;

import com.his.scs.helper.AppConstants;

public class CalculateBSLAndInsulin {

	private double insulin;
	private ArrayList<Double> bslList = new ArrayList<Double>();
	private double finalValue = AppConstants.BSL_SAFE;

	public double calculateInsulin(double bslValue) {

		double numerator = (double) (((-bslValue + AppConstants.BSL_SAFE) / AppConstants.TIME_DURATION_IN_MINUTES_INSULIN)
				+ (bslValue * AppConstants.K_OUT_G));
		double denominator = (double) (bslValue * AppConstants.K_OUT_GI);

		if (denominator != 0)
			insulin = numerator / denominator;
		insulin = -insulin;
		return insulin;

	}

	public ArrayList<Double> addBSLValuesToList(double bslValue) {

		double value = bslValue;
		int count =0;
		do {
			value = value - ((value * AppConstants.K_OUT_G) + (value * insulin * AppConstants.K_OUT_GI));
			bslList.add(value);
			count++;
		} while (value >= finalValue && count <500);

		return bslList;
	}

	public double calculateFinalLevelFromInsulinDosage() {

		finalValue = - AppConstants.BSL_PREVIOUS +
				(((insulin*AppConstants.K_OUT_GI*AppConstants.BSL_PREVIOUS)-(AppConstants.K_OUT_G*AppConstants.BSL_PREVIOUS))*AppConstants.TIME_DURATION_IN_MINUTES_INSULIN) ;
		return finalValue;
	}

	public double getInsulin() {
		return insulin;
	}

	public void setInsulin(double insulin) {
		this.insulin = insulin;
	}

}
