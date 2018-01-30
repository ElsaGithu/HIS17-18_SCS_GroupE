package com.his.scs.model;

import java.util.Observable;

import com.his.scs.helper.AppConstants;
import com.his.scs.helper.SaveHormoneReserves;

@SuppressWarnings("deprecation")
public class UpdateHormonReserve extends Observable {
	private HormoneBean hormone = new HormoneBean();


	public void updateInsulin(double value) {
		AppConstants.updateInsulinUsed(value);
		new SaveHormoneReserves().writeToFile(AppConstants.getTOTAL_INSULIN_USED(), AppConstants.HORMONE_TYPE_INSULIN);
		double insulinAvailable = (AppConstants.getTOTAL_INSULIN() - AppConstants.getTOTAL_INSULIN_USED());
		int percent = (int) ((insulinAvailable) / (AppConstants.getTOTAL_INSULIN()) * 100);

		hormone.setType(AppConstants.HORMONE_TYPE_INSULIN);
		hormone.setAmount(percent);
		setChanged();
		notifyObservers(hormone);
	}

	public void updateGlucagon(double value) {
		AppConstants.updateGlucagonUsed(value);
		new SaveHormoneReserves().writeToFile(AppConstants.getTOTAL_GLUCAGON_USED(), AppConstants.HORMONE_TYPE_GLUCAGON);
		double glucagonAvailable = (AppConstants.getTOTAL_GLUCAGON() - AppConstants.getTOTAL_GLUCAGON_USED());
		int percent = (int) ((glucagonAvailable) / (AppConstants.getTOTAL_GLUCAGON()) * 100);
		hormone.setType(AppConstants.HORMONE_TYPE_GLUCAGON);
		hormone.setAmount(percent);
		setChanged();
		notifyObservers(hormone);
	}

}
