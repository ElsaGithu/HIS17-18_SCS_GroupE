package com.his.scs.controller;

import com.his.scs.model.DoctorPatientHistoryModel;
import com.his.scs.view.DoctorPatientHistoryView;

public class DoctorPatientHistoryController {

	private DoctorPatientHistoryView theView;
	private DoctorPatientHistoryModel theModel;

	public DoctorPatientHistoryController(DoctorPatientHistoryView theView, DoctorPatientHistoryModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
	}

}
