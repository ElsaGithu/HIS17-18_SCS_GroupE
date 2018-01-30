package com.his.scs.controller;

import com.his.scs.model.EmergencyPatientHistoryModel;
import com.his.scs.view.EmergencyPatientHistoryView;

public class EmergencyPatientHistoryController {
	private EmergencyPatientHistoryView theView;
	private EmergencyPatientHistoryModel theModel;
	
	public EmergencyPatientHistoryController(EmergencyPatientHistoryView theView,EmergencyPatientHistoryModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
	}

}
