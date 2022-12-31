package com.stx.centre.security;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

import com.stx.centre.security.user.principals.GroupPrincipal;

public interface UserContext extends Cloneable {
	public static final String AUTH_APP_TOKEN = "authAppToken";
	
	LoginContext getLoginContext();
	
	Subject getSubject();
	
	String getUserId();
	
	String getEmail();
	
	String getFullName();
	
	Set<GroupPrincipal> getGroupPrincipals();
	
	String getSessionId();
	
	Locale getUserLocale();
	
	int getUserLocaleIndex();
	
	String getClientIp();
	
	Object getUserAttribute(String key);
	
	<T> T getUserAttribute(Class<T> rtnCls);
	
	String getChannel();
	
	void reset();
	
	UserContext cloneUserContext();
	
	Map<String, String> getAppContextMap();
}
