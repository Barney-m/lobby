package com.stx.centre.security.oauth2.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6908017209569430422L;

	private boolean forceLogout;
	
	private String remoteAddr;
	
	private String sessionId;
	
	private Map<String, String> additionalParams = new HashMap<>();
	
	private Map<String, String> loginOptions = new HashMap<>();

	public boolean getIsForceLogout() {
		return forceLogout;
	}

	public void setForceLogout(boolean forceLogout) {
		this.forceLogout = forceLogout;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	public Map<String, String> getLoginOptions() {
		return loginOptions;
	}

	public void setLoginOptions(Map<String, String> loginOptions) {
		this.loginOptions = loginOptions;
	}
	
	
}
