package com.stx.centre.security.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

import com.stx.centre.security.UsrCtx;
import com.stx.centre.security.user.principals.GrpPrp;
import com.stx.workshop.exception.SvcException;

public class SysUsrCtx implements UsrCtx {
	private String sysNm;
	
	private String sssId;
	
	private String cltIp;
	
	private transient Locale usrLcl = Locale.ENGLISH;
	
	private Map<String, Object> usrAttrMap = new HashMap<>();
	
	private Map<String, String> appCtxMap;
	
	public SysUsrCtx(String sysNm, String sssId, String cltIp) {
		this.sysNm = sysNm;
		this.sssId = sssId;
		this.cltIp = cltIp;
	}

	/**
	 * @return the sysNm
	 */
	public String getSysNm() {
		return sysNm;
	}

	/**
	 * @param sysNm the sysNm to set
	 */
	public void setSysNm(String sysNm) {
		this.sysNm = sysNm;
	}

	/**
	 * @return the sssId
	 */
	public String getSssId() {
		return sssId;
	}

	/**
	 * @param sssId the sssId to set
	 */
	public void setSssId(String sssId) {
		this.sssId = sssId;
	}

	/**
	 * @return the cltIp
	 */
	public String getCltIp() {
		return cltIp;
	}

	/**
	 * @param cltIp the cltIp to set
	 */
	public void setCltIp(String cltIp) {
		this.cltIp = cltIp;
	}

	/**
	 * @return the usrLcl
	 */
	public Locale getUsrLcl() {
		return usrLcl;
	}

	/**
	 * @param usrLcl the usrLcl to set
	 */
	public void setUsrLcl(Locale usrLcl) {
		this.usrLcl = usrLcl;
	}

	/**
	 * @return the usrAttrMap
	 */
	public Map<String, Object> getUsrAttrMap() {
		return usrAttrMap;
	}

	/**
	 * @param usrAttrMap the usrAttrMap to set
	 */
	public void setUsrAttrMap(Map<String, Object> usrAttrMap) {
		this.usrAttrMap = usrAttrMap;
	}

	/**
	 * @return the appCtxMap
	 */
	public Map<String, String> getAppCtxMap() {
		return appCtxMap;
	}

	/**
	 * @param appCtxMap the appCtxMap to set
	 */
	public void setAppCtxMap(Map<String, String> appCtxMap) {
		this.appCtxMap = appCtxMap;
	}

	@Override
	public LoginContext getLoginCtx() {
		return null;
	}

	@Override
	public Subject getSbj() {
		return null;
	}

	@Override
	public String getUsrId() {
		return null;
	}

	@Override
	public String getEmail() {
		return null;
	}

	@Override
	public String getFullNm() {
		return null;
	}

	@Override
	public Set<GrpPrp> getGrpPrps() {
		return Collections.emptySet();
	}

	@Override
	public int getUsrLclIdx() {
		return 0;
	}

	@Override
	public Object getUsrAttr(String key) {
		return null;
	}

	@Override
	public <T> T getUsrAttr(Class<T> rtnCls) {
		return null;
	}

	@Override
	public String getChan() {
		return null;
	}

	@Override
	public void reset() {
		this.sysNm = null;
		this.sssId = null;
		this.cltIp = null;
		this.appCtxMap = null;
		this.usrLcl = Locale.ENGLISH;
	}

	@Override
	public UsrCtx cloneUsrCtx() {
		try {
			return (UsrCtx) this.clone();
		} catch (CloneNotSupportedException ex) {
			throw new SvcException(ex);
		}
	}
}
