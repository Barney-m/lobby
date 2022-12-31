package com.stx.centre.security;

import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.stx.centre.security.user.SystemUserContext;
import com.stx.workshop.util.PropertyUtil;

public final class UserContextUtil {
	public static final String SYSTEM = "system";
	
	public static final String SYSTEM_EMAIL = PropertyUtil.getDefEmail();
	
	public static final String LOCAL_HOST_IP = "127.0.0.1";
	
	private static ThreadLocal<UserContext> userContext = new ThreadLocal<>();
	
	private static final ThreadLocal<String> threadId = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return UUID.randomUUID().toString().toUpperCase();
		}
	};
	
	private UserContextUtil() {}
	
	public static String getThreadId() {
		return threadId.get();
	}
	
	public static UserContext getUserContext() {
		return userContext.get();
	}
	
	public static String getUserId() {
		UserContext context = getUserContext();
		
		if (null == context) {
			return null;
		}
		
		return context.getUserId();
	}
	
	public static String getUserEmail() {
		UserContext context = getUserContext();
		
		if (null == context) {
			return null;
		}
		
		return context.getEmail();
	}
	
	public static String getFullName() {
		UserContext context = getUserContext();
		
		if (null == context) {
			return null;
		}
		
		return context.getFullName();
	}
	
	public static String getClientIp() {
		UserContext context = getUserContext();
		
		if (null == context) {
			return null;
		}
		
		return context.getClientIp();
	}
	
	public static Locale getUserLocale() {
		UserContext context = getUserContext();
		
		if (null == context) {
			return Locale.ENGLISH;
		}
		
		Locale locale = context.getUserLocale();
		return null == locale ? Locale.ENGLISH : locale;
	}
	
	public static void setUserContext(UserContext context) {
		if (null == context) {
			userContext.remove();
			return;
		}
		
		userContext.set(context);
	}
	
	public static void setThreadId(String threadUid) {
		if (StringUtils.isBlank(threadUid)) {
			threadId.remove();
			return;
		}
		
		threadId.set(threadUid);
	}
	
	public static void initSystemUser() {
		UserContext context = new SystemUserContext(SYSTEM, null, LOCAL_HOST_IP);
		setUserContext(context);
	}
	
	public static String getAuthToken() {
		UserContext context = getUserContext();
		
		if (null != context && null != context.getUserAttribute(UserContext.AUTH_APP_TOKEN)) {
			return (String) context.getUserAttribute(UserContext.AUTH_APP_TOKEN);
		}
		
		return null;
	}
	
	public static Map<String, String> getAppContextMap() {
		UserContext context = getUserContext();
		
		if (null == context) {
			return null;
		}
		
		return context.getAppContextMap();
	}
}
