package com.stx.centre.security.web.bean;

import com.stx.centre.security.user.bean.CentreUser;

public class CentreLoginRsp {

	protected String sessionId;
	
	protected String accessToken;
	
	protected String accessTokenExpireAt;
	
	protected String refreshToken;
	
	protected String refreshTokenExpireAt;
	
	protected CentreUser user;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenExpireAt() {
		return accessTokenExpireAt;
	}

	public void setAccessTokenExpireAt(String accessTokenExpireAt) {
		this.accessTokenExpireAt = accessTokenExpireAt;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getRefreshTokenExpireAt() {
		return refreshTokenExpireAt;
	}

	public void setRefreshTokenExpireAt(String refreshTokenExpireAt) {
		this.refreshTokenExpireAt = refreshTokenExpireAt;
	}

	public CentreUser getUser() {
		return user;
	}

	public void setUsr(CentreUser user) {
		this.user = user;
	}
}
