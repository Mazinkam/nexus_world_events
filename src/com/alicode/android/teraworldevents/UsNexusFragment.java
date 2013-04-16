/***
  Copyright (c) 2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  From _The Busy Coder's Guide to Android Development_
    http://commonsware.com/Android
 */

package com.alicode.android.teraworldevents;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.alicode.android.teraworldevents.R;

public class UsNexusFragment extends SherlockFragment {
	private static final String KEY_POSITION = "position";
	private static final String KEY_TEXT = "text";
	private static boolean nexusDone = false;
	private int diffHours;
	private ColorSelection chosen;

	TimeConvertion timeConvMon1;
	TimeConvertion timeConvMon2;
	TimeConvertion timeConvTue;
	TimeConvertion timeConvThur;
	TimeConvertion timeConvFri1;
	TimeConvertion timeConvFri2;
	TimeConvertion timeConvSat1;
	TimeConvertion timeConvSat2;
	TimeConvertion timeConvSat3;
	TimeConvertion timeConvSun1;
	TimeConvertion timeConvSun2;
	TimeConvertion timeConvSun3;
	private TextView nextNexus;

	static UsNexusFragment newInstance(int position, CharSequence text) {
		UsNexusFragment frag = new UsNexusFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);
		frag.setArguments(args);

		return (frag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.nexus_us, container, false);

		nextNexus = (TextView) result.findViewById(R.id.na_next_nexus);

		chosen = new ColorSelection();

		timeConvMon1 = new TimeConvertion(12, 2, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusMonday = (TextView) result
				.findViewById(R.id.na_mon_1);
		if (chosen.swapColor() == 2) {
			nexusMonday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvMon1);
		}
		nexusMonday.setText("" + timeConvMon1.getLocalDate());

		// Monday 2

		timeConvMon2 = new TimeConvertion(19, 2, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusMonday2 = (TextView) result
				.findViewById(R.id.na_mon_2);
		if (chosen.swapColor() == 2) {
			nexusMonday2.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvMon2);
		}
		nexusMonday2.setText("" + timeConvMon2.getLocalDate());

		// Tues------------------------------------------------------------------------------------------------------------------------

		timeConvTue = new TimeConvertion(18, 3, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusTuesday = (TextView) result
				.findViewById(R.id.na_tue_1);

		if (chosen.swapColor() == 3) {
			nexusTuesday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvTue);
		}
		nexusTuesday.setText("" + timeConvTue.getLocalDate() );

		// wed------------------------------------------------------------------------------------------------------------------------

		final TextView nexusWednsday = (TextView) result
				.findViewById(R.id.na_wed_1);

		if (chosen.swapColor() == 4)
			nexusWednsday.setTextColor(Color.argb(255, 0, 222, 255));

		nexusWednsday.setText("No Nexus.");

		// Thurs------------------------------------------------------------------------------------------------------------------------
		timeConvThur = new TimeConvertion(18, 5, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusThursday = (TextView) result
				.findViewById(R.id.na_thur_1);

		if (chosen.swapColor() == 5) {
			nexusThursday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvThur);
		}
		nexusThursday.setText("" + timeConvThur.getLocalDate());

		// Friday

		timeConvFri1 = new TimeConvertion(12, 6, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusFriday = (TextView) result
				.findViewById(R.id.na_fri_1);

		if (chosen.swapColor() == 6) {
			nexusFriday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvFri1);
		}
		nexusFriday.setText("" + timeConvFri1.getLocalDate());

		timeConvFri2 = new TimeConvertion(19, 6, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusFriday2 = (TextView) result
				.findViewById(R.id.na_fri_2);

		if (chosen.swapColor() == 6) {
			nexusFriday2.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvFri2);
		}
		nexusFriday2.setText("" + timeConvFri2.getLocalDate());

		// Sat
		// -------------------------------------------------------------------------------------------------------------------

		timeConvSat1 = new TimeConvertion(2, 7, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusSaturday = (TextView) result
				.findViewById(R.id.na_sat_1);

		if (chosen.swapColor() == 7) {
			nexusSaturday.setTextColor(Color.argb(255, 0, 222, 255));
			timeCheck(timeConvSat1);
		}
		nexusSaturday.setText("" + timeConvSat1.getLocalDate());

		timeConvSat2 = new TimeConvertion(12, 7, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusSaturday2 = (TextView) result
				.findViewById(R.id.na_sat_2);

		if (chosen.swapColor() == 7) {
			nexusSaturday2.setTextColor(Color.argb(255, 0, 222, 255));
		}
		nexusSaturday2.setText("" + timeConvSat2.getLocalDate());

		timeConvSat3 = new TimeConvertion(19, 7, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusSaturday3 = (TextView) result
				.findViewById(R.id.na_sat_3);

		if (chosen.swapColor() == 7) {
			nexusSaturday3.setTextColor(Color.argb(255, 0, 222, 255));
		}
		nexusSaturday3.setText("" + timeConvSat3.getLocalDate());

		// Sun

		timeConvSun1 = new TimeConvertion(2, 1, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusSunday = (TextView) result
				.findViewById(R.id.na_sun_1);

		if (chosen.swapColor() == 1) {
			nexusSunday.setTextColor(Color.argb(255, 0, 222, 255));
		}
		nexusSunday.setText("" + timeConvSun1.getLocalDate());

		timeConvSun2 = new TimeConvertion(12, 1, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusSunday2 = (TextView) result
				.findViewById(R.id.na_sun_2);

		if (chosen.swapColor() == 1) {
			nexusSunday2.setTextColor(Color.argb(255, 0, 222, 255));
		}
		nexusSunday2.setText("" + timeConvSun2.getLocalDate());

		timeConvSun3 = new TimeConvertion(19, 1, TimeZone.getTimeZone("GMT-7"));

		final TextView nexusSunday3 = (TextView) result
				.findViewById(R.id.na_sun_3);

		if (chosen.swapColor() == 1) {
			nexusSunday3.setTextColor(Color.argb(255, 0, 222, 255));
		}
		nexusSunday3.setText("" + timeConvSun3.getLocalDate());

		closestNexus();

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
			} else if (timeConvSun2.getLocalDate().before(
					timeConvSun3.getLocalDate())) {
				timeCheck(timeConvSun2);
			} else
				timeCheck(timeConvSun3);
		}
		if (chosen.swapColor() == 2) {
			// timeCheck(timeConvSun3);
			if (timeConvMon1.getLocalDate().after(timeConvMon2.getLocalDate())) {
				timeCheck(timeConvMon1);
			} else
				timeCheck(timeConvMon2);
		}
		if (chosen.swapColor() == 3) {
			timeCheck(timeConvTue);
		}
		
		if (chosen.swapColor() == 4) 
		
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
			} else if (timeConvSat2.getLocalDate().before(
					timeConvSat3.getLocalDate())) {
				timeCheck(timeConvSat2);
			} else
				timeCheck(timeConvSat3);
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
