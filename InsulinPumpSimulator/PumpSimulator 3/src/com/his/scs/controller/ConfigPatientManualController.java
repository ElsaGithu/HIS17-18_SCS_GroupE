package com.his.scs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.his.scs.exceptions.InvalidFormatException;
import com.his.scs.model.ConfigPatientManualModel;
import com.his.scs.view.ConfigPatientManualView;

public class ConfigPatientManualController {

	private ConfigPatientManualView theView;
	private ConfigPatientManualModel theModel;

	public ConfigPatientManualController(ConfigPatientManualView theView,ConfigPatientManualModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.SaveManualModeListener(new SettingManualModeListener());
	}

	class SettingManualModeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Inside SettingManualModeListener of controller");
			try {
				theModel.writeManualModeSettingsToFile(theView.getChckbxManualMode(),theView.getInsulinDosageField(),theView.getGlucagonDosageField());
				theView.displaySuccessMessage("Saved Settings");
			}
			catch(InvalidFormatException e) {
				theView.displayErrorMessage("ERROR::"+ e);
			}

		}
	}	

}
