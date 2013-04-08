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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.alicode.android.teraworldevents.R;

public class UsNexusFragment extends SherlockFragment {
	private static final String KEY_POSITION = "position";
	private static final String KEY_TEXT = "text";

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

		Calendar cal = Calendar.getInstance();
		ColorSelection chosen = new ColorSelection();
		// Monday------------------------------------------------------------------------------------------------------------------------
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.DAY_OF_WEEK, 2);

		cal.setTimeZone(TimeZone.getTimeZone("PDT"));

		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		final TextView nexusMonday = (TextView) result
				.findViewById(R.id.na_mon_2);
		try {
			if (chosen.swapColor() == 2) {
				nexusMonday.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusMonday.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Monday 2
		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.DAY_OF_WEEK, 2);

		final TextView nexusMonday2 = (TextView) result
				.findViewById(R.id.na_mon_1);
		try {
			if (chosen.swapColor() == 3) {
				nexusMonday2.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusMonday2.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Tues------------------------------------------------------------------------------------------------------------------------

		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.DAY_OF_WEEK, 3);


		final TextView nexusTuesday = (TextView) result
				.findViewById(R.id.na_tue_1);
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

		// wed------------------------------------------------------------------------------------------------------------------------

		final TextView nexusWednsday = (TextView) result
				.findViewById(R.id.na_wed_1);

		if (chosen.swapColor() == 4)
			nexusWednsday.setTextColor(Color.argb(255, 0, 222, 255));

		nexusWednsday.setText("No Nexus.");

		// Thurs------------------------------------------------------------------------------------------------------------------------
		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.DAY_OF_WEEK, 5);


		final TextView nexusThursday = (TextView) result
				.findViewById(R.id.na_thur_1);
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
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.DAY_OF_WEEK, 6);


		final TextView nexusFriday = (TextView) result
				.findViewById(R.id.na_fri_2);
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

		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.DAY_OF_WEEK, 6);


		final TextView nexusFriday2 = (TextView) result
				.findViewById(R.id.na_fri_1);
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

		// Sat -------------------------------------------------------------------------------------------------------------------
		cal.set(Calendar.HOUR_OF_DAY, 2);
		cal.set(Calendar.DAY_OF_WEEK, 7);

		final TextView nexusSaturday = (TextView) result
				.findViewById(R.id.na_sat_1);
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

		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.DAY_OF_WEEK, 7);

		final TextView nexusSaturday2 = (TextView) result
				.findViewById(R.id.na_sat_3);
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

		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.DAY_OF_WEEK, 7);


		final TextView nexusSaturday3 = (TextView) result
				.findViewById(R.id.na_sat_2);
		try {
			if (chosen.swapColor() == 7) {
				nexusSaturday3.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusSaturday3.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sun
		cal.set(Calendar.HOUR_OF_DAY, 2);
		cal.set(Calendar.DAY_OF_WEEK, 1);


		final TextView nexusSunday = (TextView) result
				.findViewById(R.id.na_sun_1);
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

		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.DAY_OF_WEEK, 1);


		final TextView nexusSunday2 = (TextView) result
				.findViewById(R.id.na_sun_3);
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

		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.DAY_OF_WEEK, 1);

		final TextView nexusSunday3 = (TextView) result
				.findViewById(R.id.na_sun_2);
		try {
			if (chosen.swapColor() == 1) {
				nexusSunday3.setTextColor(Color.argb(255, 0, 222, 255));
			}
			nexusSunday3.setText(""
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (result);
	}
}
