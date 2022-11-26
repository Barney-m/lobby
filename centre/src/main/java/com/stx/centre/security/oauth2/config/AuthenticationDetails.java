package com.stx.centre.security.oauth2.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6908017209569430422L;

	private boolean frcLogout;
	
	private String remoteAddr;
	
	private String sssId;
	
	private Map<String, String> adlPmrs = new HashMap<>();
	
	private Map<String, String> loginOpts = new HashMap<>();

	public boolean isFrcLogout() {
		return frcLogout;
	}

	public void setFrcLogout(boolean frcLogout) {
		this.frcLogout = frcLogout;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getSssId() {
		return sssId;
	}

	public void setSssId(String sssId) {
		this.sssId = sssId;
	}

	public Map<String, String> getAdlPmrs() {
		return adlPmrs;
	}

	public void setAdlPmrs(Map<String, String> adlPmrs) {
		this.adlPmrs = adlPmrs;
	}

	public Map<String, String> getLoginOpts() {
		return loginOpts;
	}

	public void setLoginOpts(Map<String, String> loginOpts) {
		this.loginOpts = loginOpts;
	}
	
	
}
