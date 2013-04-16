package com.alicode.android.teraworldevents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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
	private static boolean nexusDone = true;
	private int diffHours;
	private ColorSelection chosen;

	TimeConvertion timeConvMon1;
	TimeConvertion timeConvMon2;
	TimeConvertion timeConvTue;
	TimeConvertion timeConvWed1;
	TimeConvertion timeConvWed2;
	TimeConvertion timeConvThur;
	TimeConvertion timeConvFri1;
	TimeConvertion timeConvFri2;
	TimeConvertion timeConvSat1;
	TimeConvertion timeConvSat2;

	TimeConvertion timeConvSun1;
	TimeConvertion timeConvSun2;

	private TextView nextNexus;

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

		nextNexus = (TextView) result.findViewById(R.id.eu_next_nexus);

		ColorSelection chosen = new ColorSelection();

		// Mon
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		final TextView nexusMonday = (TextView) result
				.findViewById(R.id.eu_mon_1);

		if (chosen.swapColor() == 2) {
			nexusMonday.setTextColor(Color.argb(255, 0, 222, 255));

		}
		nexusMonday.setText("No Nexus.");

		// tues

		timeConvTue = new TimeConvertion(20, 3, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusTuesday = (TextView) result
				.findViewById(R.id.eu_tue_1);

		if (chosen.swapColor() == 3) {
			nexusTuesday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvTue);
		}
		nexusTuesday.setText("" + timeConvTue.getLocalDate());

		// Wedns

		timeConvWed1 = new TimeConvertion(15, 4, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusWednesday = (TextView) result
				.findViewById(R.id.eu_wed_1);

		if (chosen.swapColor() == 4) {
			nexusWednesday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvWed1);
		}
		nexusWednesday.setText("" + timeConvWed1.getLocalDate());

		timeConvWed2 = new TimeConvertion(21, 4, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusWednesday2 = (TextView) result
				.findViewById(R.id.eu_wed_2);

		if (chosen.swapColor() == 4) {
			nexusWednesday2.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvWed2);
		}
		nexusWednesday2.setText("" + timeConvWed2.getLocalDate());

		// Thurs
		timeConvThur = new TimeConvertion(20, 5, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusThursday = (TextView) result
				.findViewById(R.id.eu_thur_1);

		if (chosen.swapColor() == 5) {
			nexusThursday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvThur);
		}
		nexusThursday.setText("" + timeConvThur.getLocalDate());

		// Friday
		timeConvFri1 = new TimeConvertion(18, 6, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusFriday = (TextView) result
				.findViewById(R.id.eu_fri_1);

		if (chosen.swapColor() == 6) {
			nexusFriday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvFri1);
		}
		nexusFriday.setText("" + timeConvFri1.getLocalDate());

		timeConvFri2 = new TimeConvertion(21, 6, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusFriday2 = (TextView) result
				.findViewById(R.id.eu_fri_2);

		if (chosen.swapColor() == 6) {
			nexusFriday2.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvFri2);
		}
		nexusFriday2.setText("" + timeConvFri2.getLocalDate());

		// Sat
		timeConvSat1 = new TimeConvertion(15, 7, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusSaturday = (TextView) result
				.findViewById(R.id.eu_sat_1);

		if (chosen.swapColor() == 7) {
			nexusSaturday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvSat1);
		}
		nexusSaturday.setText("" + timeConvSat1.getLocalDate());

		timeConvSat2 = new TimeConvertion(21, 7, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusSaturday2 = (TextView) result
				.findViewById(R.id.eu_sat_2);

		if (chosen.swapColor() == 7) {
			nexusSaturday2.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvSat2);
		}
		nexusSaturday2.setText("" + timeConvSat2.getLocalDate());

		// Sun
		timeConvSun1 = new TimeConvertion(15, 1, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusSunday = (TextView) result
				.findViewById(R.id.eu_sun_1);

		if (chosen.swapColor() == 1) {
			nexusSunday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvSun1);
		}
		nexusSunday.setText("" + timeConvSun1.getLocalDate());

		timeConvSun2 = new TimeConvertion(21, 1, TimeZone.getTimeZone("GMT+2"));

		final TextView nexusSunday2 = (TextView) result
				.findViewById(R.id.eu_sun_2);

		if (chosen.swapColor() == 1) {
			nexusSunday2.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvSun2);
		}
		nexusSunday2.setText("" + timeConvSun2.getLocalDate());

		return (result);

	}

	public void timeCheck(TimeConvertion d) {
		if (d.getLocalDate().after(new Date())) {
			long time = (d.getLocalDateLong() - System.currentTimeMillis() / 1000);
			diffHours = (int) (time / 3600);

			startTimer(d.getMS());

		}
	}

	public void closestNexus() {
		if (chosen.swapColor() == 1) {
			// timeCheck(timeConvSun3);
			if (timeConvSun1.getLocalDate().after(timeConvSun2.getLocalDate())) {
				timeCheck(timeConvSun1);
			} else
				timeCheck(timeConvSun2);
		}
		if (chosen.swapColor() == 2) {

		}
		if (chosen.swapColor() == 3) {
			timeCheck(timeConvTue);
		}

		if (chosen.swapColor() == 4) {
			// timeCheck(timeConvSun3);
			if (timeConvWed1.getLocalDate().after(timeConvWed2.getLocalDate())) {
				timeCheck(timeConvMon1);
			} else
				timeCheck(timeConvWed2);
		}

		if (chosen.swapColor() == 5)
			timeCheck(timeConvThur);

		if (chosen.swapColor() == 6) {

			if (timeConvFri1.getLocalDate().after(timeConvFri1.getLocalDate())) {
				timeCheck(timeConvFri1);
			} else
				timeCheck(timeConvFri2);
		}
		if (chosen.swapColor() == 7) {

			if (timeConvSat1.getLocalDate().after(timeConvSat2.getLocalDate())) {
				timeCheck(timeConvSat1);
			} else
				timeCheck(timeConvSat2);
		}

	}

	public void startTimer(long chosenNexus) {
		new CountDownTimer(chosenNexus, 1000) {

			public void onTick(long millisUntilFinished) {
				DateFormat formatter = new SimpleDateFormat("hh:mm:ss");

				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(millisUntilFinished);
				nextNexus.setTextColor(Color.argb(255, 0, 222, 255));
				nextNexus.setText("Next nexus in: "
						+ formatter.format(calendar.getTime()));

			}

			public void onFinish() {
				nexusDone = true;
			}
		}.start();
	}

}
