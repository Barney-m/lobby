package com.stx.workshop.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class PropertyUtil extends BaseEnvUtil {
	private static final Logger LOG = LoggerFactory.getLogger(PropertyUtil.class);
	
	private static Properties mdlBldVsn;
	
	private static final String PASSWORD = "password";
	
	private static String DEF_CRCY_FMT = "#,##0.00";
	
	private static Locale DEF_LCL = Locale.ENGLISH;

	private PropertyUtil() {}
	
	public static String getDefCrcyFmt() {
		return (String) getProperty("default.currency.format", DEF_CRCY_FMT);
	}
	
	public static String getDefCrcyCode() {
		return (String) getProperty("default.currency", "MYR");
	}
	
	public static String getDefCntyCode() {
		return (String) getProperty("default.country", "MY");
	}
	
	public static String getDefDtFmt() {
		return (String) getProperty("default.date.format", "dd/MM/yyyy");
	}
	
	public static String getDefDtTmFmt() {
		return (String) getProperty("default.date.time.format", "dd/MM/yyyy HH:mm:ss, EEE");
	}
	
	public static Integer getFrstDayOfWeek() {
		Object day = getProperty("first.day.of.week", "1");
		if (day instanceof String) {
			switch (day.toString().toLowerCase()) {
				case "monday":
					return 1;
				case "tuesday":
					return 2;
				case "wednesday":
					return 3;
				case "thursday":
					return 4;
				case "friday":
					return 5;
				case "saturday":
					return 6;
				case "sunday":
					return 0;
				default:
					return -1;
					
			}
		} else if (day instanceof Integer) {
			if ((int) day >= 7) {
				return -1;
			}
		}
		
		return (int) day;
	}
	
	public static String getDefDtTmFmtWthTmz() {
		SimpleDateFormat sdf = new SimpleDateFormat("XXX");
		String utcTmz = sdf.format(DateUtil.getCurrDtTm());
		return (String) getProperty("default.date.time.format", "dd/MM/yyyy HH:mm:ss, EEE") + "\\' UTC " + utcTmz + "\\'";
	}
	
	public static String getDefDtTmFmtShrt() {
		return (String) getProperty("default.date.time.format.short", DateUtil.DEF_TMS_FMT);
	}
	
	public static String getDefTmFmt() {
		return (String) getProperty("default.time.format", "HH:mm");
	}
	
	public static String getDefPrsDtFmt() {
		return (String) getProperty("default.parse.dt.fmt", "YYYY-MM-DD");
	}
	
	public static String getEnv() {
		return (String) getProperty("app.env", "DEV");
	}
	
	public static List<String> getMdlCodes() {
		return Arrays.asList(StringUtils.split((String) getProperty("modules", ""), ","));
	}
	
	public static List<String> getMdlGrpCodes() {
		return Arrays.asList(StringUtils.split((String) getProperty("module.grps", ""), ","));
	}
	
	public static String getDefTheme() {
		return (String) getProperty("default.theme", "stx");
	}
	
	public static String getBldVrs() {
		return (String) getProperty("build.version", "1.0");
	}
	
	public static String getAppNm() {
		return (String) getProperty("app.name", "Lobby");
	}
	
	public static String getLoginMdlNm() {
		return (String) getProperty("login.module.name", "lobby");
	}
	
	public static boolean isCustomURL() {
		return (boolean) getProperty("custom.url", false, boolean.class);
	}
	
	public static String getUrlPort() {
		return (String) getProperty("custom.url.port", "");
	}
	
	public static String getUrlScheme() {
		return (String) getProperty("custom.url.scheme", "");
	}
	
	public static String getUrlDmnNm() {
		return (String) getProperty("custom.url.domain.name", "");
	}
	
	public static String getDefEmail() {
		return (String) getProperty("default.email", "system@starxus.app");
	}
}
