package com.stx.centre.security;

import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.stx.centre.security.user.SysUsrCtx;


public final class UsrCtxUtil {
	public static final String SYSTEM = "system";
	
	public static final String LC_HST_IP = "127.0.0.1";
	
	private static ThreadLocal<UsrCtx> usrCtx = new ThreadLocal<>();
	
	private static final ThreadLocal<String> thrId = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return UUID.randomUUID().toString().toUpperCase();
		}
	};
	
	private UsrCtxUtil() {}
	
	public static String getThrId() {
		return thrId.get();
	}
	
	public static UsrCtx getUsrCtx() {
		return usrCtx.get();
	}
	
	public static String getUsrId() {
		UsrCtx ctx = getUsrCtx();
		
		if (null == ctx) {
			return null;
		}
		
		return ctx.getUsrId();
	}
	
	public static String getUsrEmail() {
		UsrCtx ctx = getUsrCtx();
		
		if (null == ctx) {
			return null;
		}
		
		return ctx.getEmail();
	}
	
	public static String getUsrFullNm() {
		UsrCtx ctx = getUsrCtx();
		
		if (null == ctx) {
			return null;
		}
		
		return ctx.getFullNm();
	}
	
	public static String getUsrCltIp() {
		UsrCtx ctx = getUsrCtx();
		
		if (null == ctx) {
			return null;
		}
		
		return ctx.getCltIp();
	}
	
	public static Locale getUsrLcl() {
		UsrCtx ctx = getUsrCtx();
		
		if (null == ctx) {
			return Locale.ENGLISH;
		}
		
		Locale lcl = ctx.getUsrLcl();
		return null == lcl ? Locale.ENGLISH : lcl;
	}
	
	public static void setUsrCtx(UsrCtx ctx) {
		if (null == ctx) {
			usrCtx.remove();
			return;
		}
		
		usrCtx.set(ctx);
	}
	
	public static void setThrId(String thrUid) {
		if (StringUtils.isBlank(thrUid)) {
			thrId.remove();
			return;
		}
		
		thrId.set(thrUid);
	}
	
	public static void initSysUsr() {
		UsrCtx ctx = new SysUsrCtx(SYSTEM, null, LC_HST_IP);
		setUsrCtx(ctx);
	}
	
	public static String getAuthTkn() {
		UsrCtx ctx = getUsrCtx();
		
		if (null != ctx && null != ctx.getUsrAttr(UsrCtx.AUTH_APP_TKN)) {
			return (String) ctx.getUsrAttr(UsrCtx.AUTH_APP_TKN);
		}
		
		return null;
	}
	
	public static Map<String, String> getAppCtxMap() {
		UsrCtx ctx = getUsrCtx();
		
		if (null == ctx) {
			return null;
		}
		
		return ctx.getAppCtxMap();
	}
}
