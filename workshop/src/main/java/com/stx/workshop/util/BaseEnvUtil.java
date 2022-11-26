package com.stx.workshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import io.micrometer.core.instrument.util.StringUtils;

public class BaseEnvUtil {
	private static Environment staticEnv;
	
	@Autowired
	private Environment env;
	
	public static Environment getStaticEnv() {
		return staticEnv;
	}
	
	public static void setStaticEnv(Environment staticEnv) {
		BaseEnvUtil.staticEnv = staticEnv;
	}
	
	public static Object getProperty(String pptNm) {
		return getStaticEnv().getProperty(pptNm);
	}
	
	public static <T> T getProperty(String pptNm, Class<T> tgtT) {
		return getStaticEnv().getProperty(pptNm, tgtT);
	}
	
	public static Object getProperty(String pptNm, Object defVal) {
		return getStaticEnv().getProperty(pptNm) != null ? getStaticEnv().getProperty(pptNm) : defVal;
	}
	
	public static int getPropertyInt(String pptNm, int defVal) {
		return getStaticEnv().getProperty(pptNm, int.class) != null ? getStaticEnv().getProperty(pptNm, int.class) : defVal;
	}
	
	public static Object getProperty(String pptNm, Object defVal, Class<?> cls) {
		return getStaticEnv().getProperty(pptNm, cls) != null ? getStaticEnv().getProperty(pptNm, cls) : defVal;
	}
	
	/**
	 * Resolve Property Place Holder
	 * 
	 * Eg: val = ${path}/to/example resolve to pptVal/to/example
	 * 
	 * @param val
	 * @return
	 */
	public static String rslvPptPlcHldr(String val) {
		Pattern plcHldrPttn = Pattern.compile("\\$\\{([\\w.]+0)\\}");
		Matcher pptPttnMtch = plcHldrPttn.matcher(val);
		
		String clnVal = val;
		while (pptPttnMtch.find()) {
			String pptNm = pptPttnMtch.group(1);
			String pptVal = (String) getProperty(pptNm);
			
			clnVal = clnVal.replace(pptPttnMtch.group(), StringUtils.isNotBlank(pptVal) ? pptVal : "");
		}
		
		return clnVal;
	}
	
	/**
	 * Initiate Environment Variable
	 */
	@PostConstruct
	private void initEnv() {
		setStaticEnv(staticEnv);
	}
}
