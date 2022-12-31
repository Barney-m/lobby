package com.stx.centre.security.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

import com.stx.centre.security.UserContext;
import com.stx.centre.security.user.principals.GroupPrincipal;
import com.stx.workshop.exception.SvcException;

public class SystemUserContext implements UserContext {
	private String systemName;
	
	private String sessionId;
	
	private String clientIp;
	
	private transient Locale userLocale = Locale.ENGLISH;
	
	private Map<String, Object> userAttrMap = new HashMap<>();
	
	private Map<String, String> appContextMap;
	
	public SystemUserContext(String systemName, String sessionId, String clientIp) {
		this.systemName = systemName;
		this.sessionId = sessionId;
		this.clientIp = clientIp;
	}

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 * @param clientIp the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	/**
	 * @return the userLocale
	 */
	public Locale getUserLocale() {
		return userLocale;
	}

	/**
	 * @param userLocale the userLocale to set
	 */
	public void setUserLocale(Locale userLocale) {
		this.userLocale = userLocale;
	}

	/**
	 * @return the userAttrMap
	 */
	public Map<String, Object> getUserAttrMap() {
		return userAttrMap;
	}

	/**
	 * @param userAttrMap the userAttrMap to set
	 */
	public void setUserAttrMap(String key, Object val) {
		userAttrMap.put(key, val);
	}

	/**
	 * @return the appContextMap
	 */
	public Map<String, String> getAppContextMap() {
		return appContextMap;
	}

	/**
	 * @param appContextMap the appContextMap to set
	 */
	public void setAppContextMap(Map<String, String> appContextMap) {
		this.appContextMap = appContextMap;
	}

	@Override
	public LoginContext getLoginContext() {
		return null;
	}

	@Override
	public Subject getSubject() {
		return null;
	}

	@Override
	public String getUserId() {
		return null;
	}

	@Override
	public String getEmail() {
		return null;
	}

	@Override
	public String getFullName() {
		return null;
	}

	@Override
	public Set<GroupPrincipal> getGroupPrincipals() {
		return Collections.emptySet();
	}

	@Override
	public int getUserLocaleIndex() {
		return 0;
	}

	@Override
	public Object getUserAttribute(String key) {
		return null;
	}

	@Override
	public <T> T getUserAttribute(Class<T> returnClass) {
		return null;
	}

	@Override
	public String getChannel() {
		return null;
	}

	@Override
	public void reset() {
		this.systemName = null;
		this.sessionId = null;
		this.clientIp = null;
		this.appContextMap = null;
		this.userLocale = Locale.ENGLISH;
	}

	@Override
	public UserContext cloneUserContext() {
		try {
			return (UserContext) this.clone();
		} catch (CloneNotSupportedException ex) {
			throw new SvcException(ex);
		}
	}
}
