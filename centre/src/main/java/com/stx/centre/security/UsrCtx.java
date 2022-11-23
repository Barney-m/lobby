package com.stx.centre.security;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

import com.stx.centre.security.user.principals.GrpPrp;

public interface UsrCtx extends Cloneable {
	public static final String AUTH_APP_TKN = "authAppTkn";
	
	LoginContext getLoginCtx();
	
	Subject getSbj();
	
	String getUsrId();
	
	String getEmail();
	
	String getFullNm();
	
	Set<GrpPrp> getGrpPrps();
	
	String getSssId();
	
	Locale getUsrLcl();
	
	int getUsrLclIdx();
	
	String getCltIp();
	
	Object getUsrAttr(String key);
	
	<T> T getUsrAttr(Class<T> rtnCls);
	
	String getChan();
	
	void reset();
	
	UsrCtx cloneUsrCtx();
	
	Map<String, String> getAppCtxMap();
}
