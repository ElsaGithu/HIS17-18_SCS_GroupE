package com.his.scs.model;
import java.util.ArrayList;

import com.his.scs.helper.AppConstants;

public class SimulateFallingBSL {


	private ArrayList<Double> bslList = new ArrayList<Double>();
	private double initialBslValue;
	private double finalBslValue;

	public double calculateInsulin() {
		double insulin = 0;
		double numerator = (double) (((-initialBslValue + finalBslValue) / AppConstants.TIME_DURATION_IN_MINUTES_INSULIN)
				+ (initialBslValue * AppConstants.K_OUT_G));
		double denominator = (double) (initialBslValue * AppConstants.K_OUT_GI);

		if (denominator != 0)
			insulin = numerator / denominator;
		insulin= -insulin;
		return insulin;


	}

	public ArrayList<Double> addBSLValuesToList(double initialBslValue, double finalBslValue) {
		this.initialBslValue = initialBslValue;
		this.finalBslValue=finalBslValue;

		double insulin = calculateInsulin();
		double value = initialBslValue;

		do {
			value = value - ((value * AppConstants.K_OUT_G) + (value * insulin * AppConstants.K_OUT_GI));

			bslList.add(value);
		} while (value >= finalBslValue);

		return bslList;
	}

}
