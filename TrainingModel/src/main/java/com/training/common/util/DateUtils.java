package com.training.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String dateToString(String datePattern, Date date) {
		DateFormat df = new SimpleDateFormat(datePattern);
		return df.format(date);
	}

	public static String timestampToStringDate(String datePattern, Timestamp timestamp) {
		return dateToString(datePattern, new Date(timestamp.getTime()));
	}

	public static String timestampToStringDate(Date date) {
		DateFormat df = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DDMMMYY);
		return df.format(date);
	}
	
	public static Date stringToDate(String format, String dateStr) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		return df.parse(dateStr);
	}
	
	public static Date plusDate(Date d, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, days);
		
		return c.getTime();
	}
	
	public static Date toBeginOfDay(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}

	// dd-MMM-yyyy
	public static String timestampToStringDate2(Date date) {
		DateFormat df = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DDMMMYYYY);
		return df.format(date);
	}

	public static Timestamp stringToTimestamp(String str_date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMAT_ddMMyyyy);
		
		try {
			Date date = dateFormat.parse(str_date);
			System.out.println(date);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
		
	public static boolean isThisDateValid(String dateToValidate){
		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMAT_ddMMyyyy);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}
