package com.alicode.android.teraworldevents;

import java.util.Calendar;

public class ColorSelection {
	Calendar cal = Calendar.getInstance();
	private int chosenDay = cal.get(Calendar.DAY_OF_WEEK);
	private int chosenInt = 0;

	public int swapColor() {

		switch (chosenDay) {
		case 1:
			chosenInt = 1;
			break;
		case 2:
			chosenInt = 2;
			break;
		case 3:
			chosenInt = 3;
			break;
		case 4:
			chosenInt = 4;
			break;
		case 5:
			chosenInt = 5;
			break;
		case 6:
			chosenInt = 6;
			break;
		case 7:
			chosenInt = 7;
			break;
		}
		return chosenInt;
	}
}
