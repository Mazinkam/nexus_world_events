package com.alicode.android.teraworldevents;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import android.graphics.Color;
import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class BgArenaFragment extends SherlockFragment {
	private static final String KEY_POSITION = "position";
	private static Calendar c;
	private static Time d;
	private static Date date;

	static BgArenaFragment newInstance(int position, CharSequence text) {
		BgArenaFragment frag = new BgArenaFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);
		frag.setArguments(args);

		c = Calendar.getInstance();

		date = new Date();

		return (frag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.compete_time, container, false);

		Calendar cal = Calendar.getInstance();
		Calendar cal_next = Calendar.getInstance();

		cal.set(Calendar.WEEK_OF_MONTH, 5);
		
		cal.set(Calendar.HOUR_OF_DAY, 17);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.DAY_OF_WEEK + 3);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);

		cal.setTimeZone(TimeZone.getTimeZone("PDT"));

		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		final TextView naFwText = (TextView) result
				.findViewById(R.id.na_fw_time);
		try {
			naFwText.setTextColor(Color.argb(255, 0, 222, 255));
			naFwText.setText("Next reset: "
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cal.set(Calendar.WEEK_OF_MONTH, 1);
		final TextView naFwText2 = (TextView) result
				.findViewById(R.id.na_fw_time2);
		try {
			naFwText2.setText("Last reset: "
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		cal.set(Calendar.WEEK_OF_MONTH, 5);
		final TextView naArenaText = (TextView) result
				.findViewById(R.id.na_3v3_time);
		try {
			naArenaText.setTextColor(Color.argb(255, 0, 222, 255));
			naArenaText.setText("Next reset: "+ dateFormatLocal.parse(dateFormatLocal.format(cal
					.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cal.set(Calendar.WEEK_OF_MONTH, 1);
		final TextView naArenaText2 = (TextView) result
				.findViewById(R.id.na_3v3_time2);
		try {
			naArenaText2.setText("Last reset: "+ dateFormatLocal.parse(dateFormatLocal.format(cal
					.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final TextView euFwText = (TextView) result
				.findViewById(R.id.eu_fw_time);
		euFwText.setText("Resets every 90 days.");

		final TextView euArenaText = (TextView) result
				.findViewById(R.id.eu_3v3_time);
		euArenaText.setText("Resets every 90 days.");
		
		getArguments().getInt(KEY_POSITION, -1);

		return (result);
	}

}