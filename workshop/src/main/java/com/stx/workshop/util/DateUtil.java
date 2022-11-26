package com.stx.workshop.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public final class DateUtil {

	private static final String DT_FMT = PropertyUtil.getDefDtFmt();
	
	private static final String DT_TM_FMT = PropertyUtil.getDefDtTmFmt();
	
	private static final int FRST_DAY_OF_WEEK = PropertyUtil.getFrstDayOfWeek();
	
	public static final FastDateFormat DEF_TMS_FMT = FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss");
	
	public static final FastDateFormat YYYY_MM_DD_FMT = FastDateFormat.getInstance("yyyy-MM-dd");
	
	public static final FastDateFormat YYYYMMDD_FMT = FastDateFormat.getInstance("yyyyMMdd");
	
	public static final FastDateFormat YYYYDDMM_FMT = FastDateFormat.getInstance("yyyyddMM");
	
	public static final FastDateFormat HHMMSS_FMT = FastDateFormat.getInstance("HHmmss");
	
	public static final FastDateFormat HHMM_FMT = FastDateFormat.getInstance("HHmm");
	
	private static final FastDateFormat DEF_DT_FMTTER = FastDateFormat.getInstance(DT_FMT);
	
	private static final FastDateFormat DEF_DT_TM_FMTTER = FastDateFormat.getInstance(DT_TM_FMT);
	
	private static final int MONTH_OF_YEAR = 12;
	
	private static final int DAY_OF_WEEK = 7;
	
	private static final int LEAP_YEAR = 4;
	
	private static final Date DATE_HIGHEST_THRESHOLD;
	
	private static final Date DATE_LOWEST_THRESHOLD;
	
	private DateUtil() {}
	
	static {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2999);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		trimTm(cal);
		DATE_HIGHEST_THRESHOLD = new Date(cal.getTime().getTime());
		
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1900);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		trimTm(cal);
		DATE_LOWEST_THRESHOLD = new Date(cal.getTime().getTime());
	}
	
	public static Calendar trimTm(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	public static Date trimTm(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		trimTm(cal);
		return cal.getTime();
	}
	
	public static Date getHgsThld() {
		return DATE_HIGHEST_THRESHOLD;
	}
	
	public static Date getLwsThld() {
		return DATE_LOWEST_THRESHOLD;
	}
	
	public static Date getCurrDtTm() {
		return new Date();
	}
	
	public static Timestamp getCurrTms() {
		return new Timestamp(getCurrDtTm().getTime());
	}
	
	/**
	 * Get x day before now
	 * 
	 * @param x - How many day before
	 * @return {@link Date}
	 */
	public static Date getBfrDt(int x) {
		Calendar cal = Calendar.getInstance();
		trimTm(cal);
		cal.add(Calendar.DATE, -x);
		
		return new Date(cal.getTime().getTime());
	}
	
	/**
	 * Get x month before now
	 * 
	 * @param x - How many month before
	 * @return {@link Date}
	 */
	public static Date getBfrMth(int x) {
		Calendar cal = Calendar.getInstance();
		trimTm(cal);
		cal.add(Calendar.MONTH, -x);
		
		return new Date(cal.getTime().getTime());
	}
	
	/**
	 * Get x year before now
	 * 
	 * @param x - How many year before
	 * @return {@link Date}
	 */
	public static Date getBfrYr(int x) {
		Calendar cal = Calendar.getInstance();
		trimTm(cal);
		cal.add(Calendar.YEAR, -x);
		
		return new Date(cal.getTime().getTime());
	}
}
