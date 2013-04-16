package com.alicode.android.teraworldevents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeConvertion {
	private Calendar cal;
	private ColorSelection c;
	private static SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
			"yyyy-MMM-dd HH:mm:ss");
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MMM-dd HH:mm:ss");

	public TimeConvertion(int hour, int day, TimeZone timeZone) {
		c = new ColorSelection();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		

		cal.setTimeZone(timeZone);
		dateFormat.setTimeZone(timeZone);

		cal.set(Calendar.DAY_OF_WEEK, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
	}

	public Date getLocalDate() {
		return cal.getTime();
	}
	
	public long getLocalDateLong()
	{
		return cal.getTimeInMillis();
	}
	
	public long getMS() {
		long msTime;
		if( cal.getTimeInMillis() <= 43270000L)
		{
			msTime = (cal.getTimeInMillis()*2-7200000L) - System.currentTimeMillis();
		}
		else 
			msTime = cal.getTimeInMillis()-7200000L -  System.currentTimeMillis();
		return  msTime ;
	}

	public Date getDate() {
		try {
			return dateFormatLocal.parse(dateFormat.format(cal.getTime()));
		} catch (ParseException e) {
			return null;
		}
	}

}
