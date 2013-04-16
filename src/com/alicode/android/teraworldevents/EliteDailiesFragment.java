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
		int chosenDay;

		Calendar cal = Calendar.getInstance();
		Calendar cal_next = Calendar.getInstance();
		ColorSelection chosen = new ColorSelection();
		boolean notReset = false;

		// NA ELITE BUFFS 7 am pdt

		cal.set(Calendar.HOUR_OF_DAY, 17);

		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		TimeConvertion timeConv = new TimeConvertion(7, chosen.swapColor(),
				TimeZone.getTimeZone("GMT-7"));

		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		final TextView naElite = (TextView) result.findViewById(R.id.na_elite);

		if (notReset) {
			naElite.setTextColor(Color.argb(255, 0, 222, 255));
			naElite.setText("Today: " + timeConv.getLocalDate());
		} else {
			naElite.setText("Tomorrow: " + timeConv.getLocalDate());
		}
		notReset = false;

		// NA ELITE dailies
		cal.set(Calendar.HOUR_OF_DAY, 18);
		timeConv = new TimeConvertion(8, chosen.swapColor(),
				TimeZone.getTimeZone("GMT-7"));
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView naDailies = (TextView) result
				.findViewById(R.id.na_dailie);

		if (notReset) {
			naDailies.setTextColor(Color.argb(255, 0, 222, 255));
			naDailies.setText("Today: " + timeConv.getLocalDate());
		} else {
			naDailies.setText("Tomorrow: " + timeConv.getLocalDate());
		}
		notReset = false;

		cal.setTimeZone(TimeZone.getTimeZone("CET"));
		timeConv = new TimeConvertion(4, chosen.swapColor(),
				TimeZone.getTimeZone("GMT-7"));
		// NAdaily dungeon
		cal.set(Calendar.HOUR_OF_DAY, 10);

		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView naDailyDungeon = (TextView) result
				.findViewById(R.id.na_daily_dungeon);

		if (notReset) {
			naDailyDungeon.setTextColor(Color.argb(255, 0, 222, 255));
			naDailyDungeon.setText("Today: " + timeConv.getLocalDate());
		} else {
			naDailyDungeon.setText("Tomorrow: " + timeConv.getLocalDate());
		}

		notReset = false;

		timeConv = new TimeConvertion(15, chosen.swapColor(),
				TimeZone.getTimeZone("GMT+1"));
		cal.setTimeZone(TimeZone.getTimeZone("CET"));
		// Eu dailies
		cal.set(Calendar.HOUR_OF_DAY, 15);
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;
		final TextView euDailies = (TextView) result
				.findViewById(R.id.eu_dailie);

		if (notReset) {
			euDailies.setTextColor(Color.argb(255, 0, 222, 255));
			euDailies.setText("Today: " + timeConv.getLocalDate());
		} else {
			euDailies.setText("Tomorrow: " + timeConv.getLocalDate());
		}
		notReset = false;

		// EU Elite
		cal.set(Calendar.HOUR_OF_DAY, 24);
		timeConv = new TimeConvertion(24, chosen.swapColor(),
				TimeZone.getTimeZone("GMT+1"));
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView euElite = (TextView) result.findViewById(R.id.eu_elite);

		if (notReset) {
			euElite.setTextColor(Color.argb(255, 0, 222, 255));
			euElite.setText("Today: " + timeConv.getLocalDate());
		} else {
			euElite.setText("Tomorrow: " + timeConv.getLocalDate());
		}

		notReset = false;

		// EU Daily Dungeon
		cal.set(Calendar.HOUR_OF_DAY, 4);
		timeConv = new TimeConvertion(4, chosen.swapColor(),
				TimeZone.getTimeZone("GMT+1"));
		if (cal_next.get(Calendar.HOUR_OF_DAY) > cal.get(Calendar.HOUR_OF_DAY)) {
			cal.set(Calendar.DAY_OF_WEEK, chosen.swapColor() + 1);
		} else
			notReset = true;

		final TextView euDailyDungeon = (TextView) result
				.findViewById(R.id.eu_daily_dungeon);
		if (notReset) {
			euDailyDungeon.setTextColor(Color.argb(255, 0, 222, 255));
			euDailyDungeon.setText("Today: " + timeConv.getLocalDate());
		} else {
			euDailyDungeon.setText("Tomorrow: " + timeConv.getLocalDate());
		}

		notReset = false;

		return (result);
	}
}