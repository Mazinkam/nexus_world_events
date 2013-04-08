package com.alicode.android.teraworldevents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.alicode.android.teraworldevents.R;

public class EuNexusFragment extends SherlockFragment {
	private static final String KEY_POSITION = "position";
	private static final String KEY_TEXT = "text";

	static EuNexusFragment newInstance(int position, CharSequence text) {
		EuNexusFragment frag = new EuNexusFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);
		frag.setArguments(args);

		return (frag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.nexus_eu, container, false);

		Calendar cal = Calendar.getInstance();
		ColorSelection chosen = new ColorSelection();

		// Mon
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.DAY_OF_WEEK, 3); // tuesday

		cal.setTimeZone(TimeZone.getTimeZone("CET"));

		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		final TextView nexusMonday = (TextView) result
				.findViewById(R.id.eu_mon_1);

		if (chosen.swapColor() == 2) {
			nexusMonday.setTextColor(Color.argb(255, 0, 222, 255));
		}
		nexusMonday.setText("No Nexus.");

		// tues

		final TextView nexusTuesday = (TextView) result
				.findViewById(R.id.eu_tue_1);
		try {
			if (chosen.swapColor() == 3) {
				nexusTuesday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusTuesday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Wedns
		cal.set(Calendar.HOUR_OF_DAY, 15);
		cal.set(Calendar.DAY_OF_WEEK, 4);

		final TextView nexusWednesday = (TextView) result
				.findViewById(R.id.eu_wed_1);
		try {
			if (chosen.swapColor() == 4) {
				nexusWednesday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusWednesday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cal.set(Calendar.HOUR_OF_DAY, 21);

		final TextView nexusWednesday2 = (TextView) result
				.findViewById(R.id.eu_wed_2);
		try {
			if (chosen.swapColor() == 4) {
				nexusWednesday2.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusWednesday2.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Thurs
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.DAY_OF_WEEK, 5);

		final TextView nexusThursday = (TextView) result
				.findViewById(R.id.eu_thur_1);
		try {
			if (chosen.swapColor() == 5) {
				nexusThursday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusThursday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Friday
		cal.set(Calendar.HOUR_OF_DAY, 18);

		cal.set(Calendar.DAY_OF_WEEK, 6);

		final TextView nexusFriday = (TextView) result
				.findViewById(R.id.eu_fri_1);
		try {
			if (chosen.swapColor() == 6) {
				nexusFriday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusFriday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cal.set(Calendar.HOUR_OF_DAY, 21);

		final TextView nexusFriday2 = (TextView) result
				.findViewById(R.id.eu_fri_2);
		try {
			if (chosen.swapColor() == 6) {
				nexusFriday2.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusFriday2.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sat
		cal.set(Calendar.HOUR_OF_DAY, 15);
		cal.set(Calendar.DAY_OF_WEEK, 7);

		final TextView nexusSaturday = (TextView) result
				.findViewById(R.id.eu_sat_1);
		try {
			if (chosen.swapColor() == 7) {
				nexusSaturday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusSaturday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cal.set(Calendar.HOUR_OF_DAY, 21);

		final TextView nexusSaturday2 = (TextView) result
				.findViewById(R.id.eu_sat_2);
		try {
			if (chosen.swapColor() == 7) {
				nexusSaturday2.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusSaturday2.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sun
		cal.set(Calendar.HOUR_OF_DAY, 15);
		cal.set(Calendar.DAY_OF_WEEK, 1);

		final TextView nexusSunday = (TextView) result
				.findViewById(R.id.eu_sun_1);
		try {
			if (chosen.swapColor() == 1) {
				nexusSunday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusSunday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cal.set(Calendar.HOUR_OF_DAY, 21);

		final TextView nexusSunday2 = (TextView) result
				.findViewById(R.id.eu_sun_2);
		try {
			if (chosen.swapColor() == 1) {
				nexusSunday2.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusSunday2.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (result);
	}

}
