package com.his.scs.controller;

import com.his.scs.model.DoctorHomeModel;
import com.his.scs.view.DoctorHomeView;

public class DoctorHomeController {

	private DoctorHomeView theView;
	private DoctorHomeModel theModel;

	public DoctorHomeController(DoctorHomeView theView,DoctorHomeModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
	}


}
