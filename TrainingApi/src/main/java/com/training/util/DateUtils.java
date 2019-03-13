package com.training.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    
    public static Date addDay(Date timestamp, int amount) {
		if (timestamp != null) {
			Date date = new Date(timestamp.getTime());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, amount);
			return calendar.getTime();
		}
		return null;
	}
    
    public static Date addMonth(Date date, int amount) {
		if (date == null) {
			date = convertToStartOfDay(new Date());
		}
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		cal2.setTime(date);
		cal2.add(Calendar.MONTH, amount);
		if (getMonthDiffCalendar(cal2, cal1, false) > amount) {
			cal2.add(Calendar.MONTH, -1);
			cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		
		return cal2.getTime();
	}
    
    public static int getMonthDiffDate(Date dateEnd, Date dateStart, boolean isDayIncluded) {
    	Calendar cal1 = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	cal1.setTime(dateEnd);
    	cal2.setTime(dateStart);
    	 
    	return getMonthDiffCalendar(cal1, cal2, isDayIncluded);
    }
    
    public static int getMonthDiffCalendar(Calendar dateEnd, Calendar dateStart, boolean isDayIncluded) {
    	if (dateEnd.before(dateStart)) {
    		return 0;
    	}
    	int endDay =  dateEnd.get(Calendar.DAY_OF_MONTH);
    	int endMonth =  dateEnd.get(Calendar.MONTH);
    	int endYear = dateEnd.get(Calendar.YEAR);
    	int startDay =  dateStart.get(Calendar.DAY_OF_MONTH);
    	int startMonth =  dateStart.get(Calendar.MONTH);
    	int startYear = dateStart.get(Calendar.YEAR);
    	if (isDayIncluded) {
    		return (endYear - startYear) * 12 + (endMonth - startMonth) + (endDay >= startDay ? 1 : 0);
    	} else {
    		return (endYear - startYear) * 12 + (endMonth - startMonth);
    	}
    	
    }
	
	public static Date convertToStartOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date == null ? new Date() : date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date convertToEndOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date == null ? new Date() : date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static long getDateCountBetween(Date start, Date end) {
		return (end.getTime() - start.getTime())/ (24*60*60*1000);
	}
	

	public static Date getDateBefore(Date dateInput, boolean startOfDateFlag) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateInput == null ? new Date() : dateInput);
		calendar.add(Calendar.DATE, -1);
		if (startOfDateFlag) {
			return convertToStartOfDay(calendar.getTime());
		} else {
			return convertToEndOfDay(calendar.getTime());
		}
	}
	
	public static String generateReferenceNo(String referenceFormat) {
		Calendar currentDate = Calendar.getInstance();
		String referenceId = String.format(referenceFormat, currentDate.get(Calendar.YEAR),
				currentDate.get(Calendar.MONTH) + 1, currentDate.get(Calendar.DAY_OF_MONTH));
		return referenceId;
	}
	
	public static String generateUploadedFileName(String defaultName) {
		Calendar currentDate = Calendar.getInstance();
		String newName = defaultName + '_' + (currentDate.getTimeInMillis()/1000);
		return newName;
	}
	
	public static Double getDoubleNumberFromString(String numberString) {
		Double number = null;
		try {
			number = Double.parseDouble(numberString.replaceAll("[^0-9.Ee]", ""));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return number;
	}
	
	public static Integer getIntNumberFromString(String numberString) {
		Integer number = null;
		try {
			number = Integer.parseInt(numberString.replaceAll("[^0-9.]", ""));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return number;
	}
	
	public static Long getLongNumberFromString(String numberString) {
		Long number = null;
		try {
			number = Long.parseLong(numberString.replaceAll("[^0-9.Ee]", ""));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return number;
	}
	
	public static Date getDateFromStringDDMMYYY(String dateString, String splitChar, boolean nullToCurrent) {
		Calendar date = Calendar.getInstance();
		if (dateString == null) {
			dateString = "";
		}
		
		try {
			String[] datePart = dateString.split(splitChar);
			date.set(Calendar.DAY_OF_MONTH, getIntNumberFromString(datePart[0]));
			date.set(Calendar.MONTH, getIntNumberFromString(datePart[1]) - 1);
			date.set(Calendar.YEAR, getIntNumberFromString(datePart[2]));
			date.set(Calendar.HOUR_OF_DAY, 0);
			date.set(Calendar.MINUTE, 0);
			date.set(Calendar.SECOND, 0);
			date.set(Calendar.MILLISECOND, 0);
			
			return date.getTime();
		} catch (Exception e) {
			return nullToCurrent ? convertToStartOfDay(new Date()) : null;
		}
	}
	
	public static boolean hasValue(Object t) {
		if (t == null || "".equals(t)) {
			return false;
		}
		return true;
	}
	
	/**
	 * @Expectation get current time with format dd/mm/yyyy hh:mm:ss AM
	 *  @param no
	 *  @return time current has string type
	 *  */
	 public static String getCurrentDateAM_PM() {
		String currentTime  = Constants.EMPTY;
		GregorianCalendar gcalendar = new GregorianCalendar();
	    
		String dateCurrent  = String.valueOf(gcalendar.get(Calendar.DATE));
		String monthCurrent = String.valueOf(gcalendar.get(Calendar.MONTH));
		String yearCurrent  = String.valueOf(gcalendar.get(Calendar.YEAR));
		
		String hourCurrent  = String.valueOf(gcalendar.get(Calendar.HOUR));
		String minuteCurrent  = String.valueOf(gcalendar.get(Calendar.MINUTE));
		String secondCurrent  = String.valueOf(gcalendar.get(Calendar.SECOND));
		String amPmCurrent = Constants.HOUR_AM;
		if(gcalendar.get(Calendar.AM_PM) != 0) {
			amPmCurrent = Constants.HOUR_PM;
		}

		currentTime = dateCurrent + Constants.SLASH_FORWARD + monthCurrent  + Constants.SLASH_FORWARD + yearCurrent 
					+ Constants.SPACE + hourCurrent + Constants.IS_DIVIDED_BY + minuteCurrent + Constants.IS_DIVIDED_BY
					+ secondCurrent + Constants.SPACE + amPmCurrent ;
		return currentTime;
	}
	 
	 /**
	 * @Expectation get current time with format dd/MM/yyyy HH:mm:ss
	 *  @param no
	 *  @return time current has string type
	 *  */
	 public static String  getCurrentTime_24H() {
		String currentTime = Constants.EMPTY;
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.DD_MM_YYY_HH_MM_SS);
	    Date date = new Date();
	    currentTime = String.valueOf(formatter.format(date));
	    return currentTime;
	}
	 
	
	/**
	 * @Expectation get Calendar Code has string type
	 *  @param year
	 *  @param month
	 *  @return CalendarCode
	 *  */
	public static String getcalendarCode(int month, int year) {
		String calendarCode = String.valueOf(year) + String.valueOf(month);
		if(String.valueOf(month).length() < 2) {
			 calendarCode = String.valueOf(year) + "0" +String.valueOf(month);
		}
	    return calendarCode;
	}
	
	/**
	 * Get current date time dd_mm_yyyy format
	 * @return 
	 */
	public static String getLocalDateTimeDD_MM_YYYY() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.DD_MM_YYYY);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}


}
