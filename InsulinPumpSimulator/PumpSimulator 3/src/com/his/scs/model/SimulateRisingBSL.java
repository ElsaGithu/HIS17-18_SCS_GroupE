package com.his.scs.model;
import java.util.ArrayList;

import com.his.scs.helper.AppConstants;

public class SimulateRisingBSL {

	private ArrayList<Double> bslList = new ArrayList<Double>();
	private double initialBslValue;
	private double finalBslValue;

	public double glucagonConsumed() {


		double glucagon = (((finalBslValue-initialBslValue)/AppConstants.TIME_DURATION_IN_MINUTES_GLUCAGON)+(AppConstants.K_OUT_G*initialBslValue))/**Math.pow(10, -9)*/;
		return glucagon;

	}

	public ArrayList<Double> addBSLValuesToList(double initialBslValue, double finalBslValue) {

		this.initialBslValue = initialBslValue;
		this.finalBslValue=finalBslValue;

		double glucagon = glucagonConsumed();
		double value = initialBslValue;
		int i=0;
		do {
			value+= (AppConstants.K_IN_G*(glucagon/1000)) - (AppConstants.K_OUT_G * value) + 0.012;	
			bslList.add(value);
		} while (value <= finalBslValue);
		
		return bslList;
	}

}
