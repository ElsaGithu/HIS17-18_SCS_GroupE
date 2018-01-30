package com.his.scs.helper;

import java.awt.Component;

import javax.swing.JOptionPane;

import com.his.scs.model.UpdateHormonReserve;

public class AppConstants {

	public static final String PATIENT_HISTORY_FILE_PATH = "D:\\SCSProjectFilesFolder\\PatientHistory.txt";
	public static final String SET_MANUAL_MODE_FILE_PATH = "D:\\SCSProjectFilesFolder\\ManualMode.txt";
	public static final String PATIENT_DETAILS_FILE_PATH = "D:\\SCSProjectFilesFolder\\PatientDetails.txt";
	public static final String HORMONE_RESERVE_FILE_PATH = "D:\\SCSProjectFilesFolder\\HormoneReserve.txt";


	public static final String INSULIN_UNIT = "";
	public static final String GLUCAGON_UNIT = "";

	/**
	 * Hormone TYPES
	 */
	public static final int HORMONE_TYPE_INSULIN =1;
	public static final int HORMONE_TYPE_GLUCAGON =2;

	/*
	 * Insulin And Battery Reserves
	 */

	private static double TOTAL_INSULIN = 100;
	private static double TOTAL_GLUCAGON = 20;

	private static double TOTAL_INSULIN_USED = 0;
	private static double TOTAL_GLUCAGON_USED = 0;
	private static UpdateHormonReserve updateReserve = new UpdateHormonReserve();
	/*
	 * Equation Constants
	 */

	public final static double K_OUT_G =  0.00127;
	public final static double K_OUT_GI =  8.26*Math.pow(10, -4);
	public final static double K_IN_G = 275;
	public final static double CONVERSION_FACTOR = 18.016;
	public final static double BSL_SAFE = 5.551;
	public final static double TIME_DURATION_IN_MINUTES_INSULIN = 180;
	public final static double TIME_DURATION_IN_MINUTES_GLUCAGON = 40;

	/*
	 * BSL levels
	 */

	public final static double BSL_SAFE_UPPER = 120/CONVERSION_FACTOR;
	public final static double BSL_SAFE_LOWER = 80/CONVERSION_FACTOR;
	public static double BSL_PREVIOUS = BSL_SAFE;
	public static final double BSL_LOW_DANGER = 50;
	public static final double BSL_HIGH_DANGER = 280;

	/***
	 * Mode
	 */
	public static int MODE = 1;
	public final static int DOCTOR_MODE = 3;
	public final static int EMERGENCY_MODE = 4;
	public final static int PATIENT_MODE_AUTO = 1;
	public final static int PATIENT_MODE_MANUAL = 2;
	public static boolean AUTO_ADJUST = false;


	public static void updateGlucagonUsed(double value) {
		TOTAL_GLUCAGON_USED += value;
	}

	public static void updateInsulinUsed(double value) {
		TOTAL_INSULIN_USED += value;
	}

	public static double getTOTAL_INSULIN() {
		return TOTAL_INSULIN;
	}



	public static double getTOTAL_GLUCAGON() {
		return TOTAL_GLUCAGON;
	}

	public static double getTOTAL_INSULIN_USED() {
		return TOTAL_INSULIN_USED;
	}

	public static double getTOTAL_GLUCAGON_USED() {
		return TOTAL_GLUCAGON_USED;
	}

	public static UpdateHormonReserve getReserve() {
		return updateReserve;
	}

	public static void setHormoneBean(UpdateHormonReserve hormoneBean) {
		AppConstants.updateReserve = hormoneBean;
	}

	public static void setTOTAL_INSULIN_USED(double tOTAL_INSULIN_USED) {
		TOTAL_INSULIN_USED = tOTAL_INSULIN_USED;
	}

	public static void setTOTAL_GLUCAGON_USED(double tOTAL_GLUCAGON_USED) {
		TOTAL_GLUCAGON_USED = tOTAL_GLUCAGON_USED;
	}

	public static void showMessage(Component component, String message) {
		if(component != null)
			JOptionPane.showMessageDialog(component, message);
	}




}
