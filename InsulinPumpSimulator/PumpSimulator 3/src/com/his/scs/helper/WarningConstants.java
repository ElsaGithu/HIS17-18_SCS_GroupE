package com.his.scs.helper;

public class WarningConstants {
	public static boolean InsulinLevelWarning = false;
	public static boolean GlucagonLevelWarning = false;
	public static boolean BSLLevelWarning = false;
	
	
	public static boolean isInsulinLevelWarning() {
		return InsulinLevelWarning;
	}
	public static void setInsulinLevelWarning(boolean insulinLevelWarning) {
		InsulinLevelWarning = insulinLevelWarning;
	}
	public static boolean isGlucagonLevelWarning() {
		return GlucagonLevelWarning;
	}
	public static void setGlucagonLevelWarning(boolean glucagonLevelWarning) {
		GlucagonLevelWarning = glucagonLevelWarning;
	}
	public static boolean isBSLLevelWarning() {
		return BSLLevelWarning;
	}
	public static void setBSLLevelWarning(boolean bSLLevelWarning) {
		BSLLevelWarning = bSLLevelWarning;
	}

}
