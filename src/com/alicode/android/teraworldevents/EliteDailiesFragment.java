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
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class EliteDailiesFragment extends SherlockFragment {
	private static final String KEY_POSITION = "position";
	private static final String KEY_TEXT = "text";

	static EliteDailiesFragment newInstance(int position, CharSequence text) {
		EliteDailiesFragment frag = new EliteDailiesFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);
		frag.setArguments(args);

		return (frag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View result = inflater.inflate(R.layout.elite_dailie, container, false);

		Calendar cal = Calendar.getInstance();
		Calendar cal_next = Calendar.getInstance();
		ColorSelection chosen = new ColorSelection();
		boolean notReset = false;

		// NA ELITE BUFFS 7 am pdt

		cal.set(Calendar.HOUR_OF_DAY, 7);

		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);

		cal.setTimeZone(TimeZone.getTimeZone("PDT"));

		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		final TextView naElite = (TextView) result.findViewById(R.id.na_elite);
		try {
			if (notReset){
				naElite.setTextColor(Color.argb(255, 0, 222, 255));
			naElite.setText("Today: "
					+ dateFormatLocal.parse(dateFormatLocal.format(cal
							.getTime())));
			}
			else 
				naElite.setText("Tomorrow: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notReset = false;

		// NA ELITE dailies
		cal.set(Calendar.HOUR_OF_DAY, 8);
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView naDailies = (TextView) result
				.findViewById(R.id.na_dailie);
		try {
			if (notReset) {
				naDailies.setTextColor(Color.argb(255, 0, 222, 255));
				naDailies.setText("Today: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			} else
				naDailies.setText("Tomorrow: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notReset = false;
		
		cal.setTimeZone(TimeZone.getTimeZone("CET"));
		
		// NAdaily dungeon
		cal.set(Calendar.HOUR_OF_DAY, 13);
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView naDailyDungeon = (TextView) result
				.findViewById(R.id.na_daily_dungeon);
		try {
			if (notReset) {
				naDailyDungeon.setTextColor(Color.argb(255, 0, 222, 255));
				naDailyDungeon.setText("Today: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			} else
				naDailyDungeon.setText("Tomorrow: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		notReset = false;

		cal.setTimeZone(TimeZone.getTimeZone("CET"));

		// Eu dailies
		cal.set(Calendar.HOUR_OF_DAY, 15);
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;
		final TextView euDailies = (TextView) result
				.findViewById(R.id.eu_dailie);
		try {
			if (notReset) {
				euDailies.setTextColor(Color.argb(255, 0, 222, 255));
				euDailies.setText("Today: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			} else
				euDailies.setText("Tomorrow: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notReset = false;

		// EU Elite
		cal.set(Calendar.HOUR_OF_DAY, 24);
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView euElite = (TextView) result.findViewById(R.id.eu_elite);
		try {
			if (notReset) {
				euElite.setTextColor(Color.argb(255, 0, 222, 255));
				euElite.setText("Today: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			} else {
				euElite.setText("Tomorrow: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notReset = false;
		
		// EU Daily Dungeon
		cal.set(Calendar.HOUR_OF_DAY, 4);
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView euDailyDungeon = (TextView) result.findViewById(R.id.eu_daily_dungeon);
		try {
			if (notReset) {
				euDailyDungeon.setTextColor(Color.argb(255, 0, 222, 255));
				euDailyDungeon.setText("Today: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			} else {
				euDailyDungeon.setText("Tomorrow: "
						+ dateFormatLocal.parse(dateFormatLocal.format(cal
								.getTime())));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notReset = false;

		return (result);
	}
}