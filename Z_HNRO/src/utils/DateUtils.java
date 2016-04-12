package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DATE, 27);
		System.out.println(getExMonthLast(today).getTime());
	}
	
	/**
	 * 해당월의 마지막날이 아니면 이전달 마지막날을 반환
	 * @param cal
	 * @return
	 */
	static Calendar getExMonthLast(Calendar cal) {
		int day = cal.get(Calendar.DATE);
		int lastday = getLastDate(cal);
		// cal.getActualMaximum(Calendar.DATE);
		
		if (day != lastday) {
			cal.add(Calendar.MONTH, -1);
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		}
		
		return cal;
	}
	
	/**
	 * 해당월의 1일이 아니면 다음달 1일을 반환
	 * @param cal
	 * @return
	 */
	static Calendar getNextMonthFirst(Calendar cal) {
		int day = cal.get(Calendar.DATE);
		if (day != 1) {
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DATE, 1);
		}
		return cal;
	}
	
	/**
	 * 토요일이 아니면 전주 토요일 날짜를 반환
	 * @param cal
	 * @return
	 */
	static Calendar getExSaturday(Calendar cal) {
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if (week != 7) {
			cal.add(Calendar.DAY_OF_WEEK, -week);
		}
		return cal;
	};
	
	/**
	 * 일요일이 아니면 다음주 일요일 날짜를 반환.
	 * @param cal
	 * @return
	 */
	static Calendar getNextSunday(Calendar cal) {
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int gap = 8 - week;
		System.out.println(gap + " : " + week);
		cal.add(Calendar.DAY_OF_WEEK, gap == 7 ? 0 : gap);
		return cal;
	};
	
	/**
	 * Calender의 시, 분, 초, 밀리초를 0으로 바꾼다.
	 * @param cal
	 * @return
	 */
	static Calendar cutUnderHour(Calendar cal) {
		String dateFormat = "yyyyMMdd";
		try {
			cal.setTime(new SimpleDateFormat(dateFormat).parse(new SimpleDateFormat(dateFormat).format(cal.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
			cal = null;
		}
		
		return cal;
	}
	
	/**
	 * 해당월의 마지막 날짜를 획득한다.
	 * @param cal
	 * @return
	 */
	static int getLastDate(Calendar cal) {
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		// int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // DAY_OF_MONTH와 DATE는 똑같이 5 값을 가지는 상수이므로, 동일한 결과를 얻을 수 있다.
		return lastDate;
	}
	
	/**
	 * 지정한 기간만큼 날짜를 변경
	 * @param date
	 * @param period 음수값을 넣으면 전일, 양수값을 넣으면 후일로 계산
	 * @return
	 */
	static Calendar calculateDate(Date date, int period) {
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		result.add(Calendar.DATE, period);
		return result;
	}
	
	/**
	 * Date를 Calendar로 변경
	 * @param date
	 * @return
	 */
	static Calendar convertDateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * Calendar를 Date로 변경
	 * @param cal
	 * @return
	 */
	static Date convertCalendarToDate(Calendar cal) {
		return new Date(cal.getTimeInMillis());
	}
	
	/**
	 * 날짜를 포멧에 맞게 문자열로 반환
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 날짜를 포멧에 맞게 문자열로 반환
	 * @param date
	 * @return
	 */
	public static String toString(Date date) {
		return toString(date, "yyyy-MM-dd");
	}
	
	/**
	 * 날짜를 포멧에 맞게 문자열로 반환
	 * @param cal
	 * @param format
	 * @return
	 */
	public static String toString(Calendar cal, String format) {
		return toString(cal.getTime(), format);
	}
	
	/**
	 * 날짜를 포멧에 맞게 문자열로 반환
	 * @param cal
	 * @return
	 */
	public static String toString(Calendar cal) {
		return toString(cal.getTime(), "yyyy-MM-dd");
	}
}
