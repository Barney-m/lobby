/**
 * 
 */
package com.stx.centre.security.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

import org.springframework.util.CollectionUtils;

import com.stx.centre.security.UsrCtx;
import com.stx.centre.security.user.principals.GrpPrp;
import com.stx.centre.security.user.principals.UsrPrp;
import com.stx.workshop.exception.SvcException;

/**
 * @author Ken Shen
 * @version 1.0
 */
public class StxUsrCtx implements UsrCtx, Serializable{
	private static final long serialVersionUID = 5752788078420473251L;

	private Map<String, Object> usrAttrMap = new HashMap<>();
	
	private Subject sbj;
	
	private transient LoginContext loginCtx;
	
	private Set<GrpPrp> grpPrps;
	
	private String sssId;
	
	private String cltIp;
	
	private String chan;
	
	private transient Locale usrLcl = Locale.ENGLISH;
	
	private String usrLang = "en";
	
	private int usrLclIdx = 0;
	
	private Map<String, String> appCtxMap;
	
	/**
	 * Store Login Context After Login Successfully
	 * 
	 * @param loginCtx JAAS Login Context
	 */
	public void setLoginCtx(LoginContext loginCtx) {
		this.loginCtx = loginCtx;
		sbj = loginCtx.getSubject();
		
		if (sbj != null) {
			grpPrps = new HashSet<>();
			
			for (Iterator<GrpPrp> prps = sbj.getPrincipals(GrpPrp.class).iterator(); prps.hasNext();) {
				grpPrps.add(prps.next());
			}
		}
	}
	
	@Override
	public LoginContext getLoginCtx() {
		return loginCtx;
	}
	
	/**
	 * Get User ID
	 */
	@Override
	public String getUsrId() {
		Set<UsrPrp> usrs = sbj.getPrincipals(UsrPrp.class);
		
		if (!CollectionUtils.isEmpty(usrs)) {
			return usrs.iterator().next().getName();
		}
		
		return null;
	}
	
	/**
	 * Get User Email
	 */
	@Override
	public String getEmail() {
		Set<UsrPrp> usrs = sbj.getPrincipals(UsrPrp.class);
		
		if (!CollectionUtils.isEmpty(usrs)) {
			return usrs.iterator().next().getEmail();
		}
		
		return null;
	}
	
	/**
	 * Get User Full Name
	 */
	@Override
	public String getFullNm() {
		Set<UsrPrp> usrs = sbj.getPrincipals(UsrPrp.class);
		
		if (!CollectionUtils.isEmpty(usrs)) {
			return usrs.iterator().next().getFullNm();
		}
		
		return null;
	}
	
	@Override
	public Set<GrpPrp> getGrpPrps() {
		return grpPrps;
	}
	
	public void setGrpPrps(Set<GrpPrp> grpPrps) {
		this.grpPrps = grpPrps;
	}

	/**
	 * @return the usrAttrMap
	 */
	public Object getUsrAttr(String key) {
		return usrAttrMap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getUsrAttr(Class<T> rtnCls) {
		return (T) usrAttrMap.get(rtnCls.getName());
	}

	/**
	 * @param usrAttrMap the usrAttrMap to set
	 */
	public void setUsrAttrMap(String key, Object val) {
		usrAttrMap.put(key, val);
	}

	/**
	 * @return the sbj
	 */
	public Subject getSbj() {
		return sbj;
	}

	/**
	 * @param sbj the sbj to set
	 */
	public void setSbj(Subject sbj) {
		this.sbj = sbj;
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
	 * @return the chan
	 */
	public String getChan() {
		return chan;
	}

	/**
	 * @param chan the chan to set
	 */
	public void setChan(String chan) {
		this.chan = chan;
	}

	/**
	 * @return the usrLcl
	 */
	public Locale getUsrLcl() {
		if (null == usrLcl) {
			usrLcl = Locale.ENGLISH;
		}
		
		return usrLcl;
	}

	/**
	 * @param usrLcl the usrLcl to set
	 */
	public void setUsrLcl(Locale usrLcl) {
		this.usrLcl = usrLcl;
		// Code your logic for indexing supported locale here...
	}

	/**
	 * @return the usrLang
	 */
	public String getUsrLang() {
		return usrLang;
	}

	/**
	 * @param usrLang the usrLang to set
	 */
	public void setUsrLang(String usrLang) {
		this.usrLang = usrLang;
	}

	/**
	 * @return the usrLclIdx
	 */
	public int getUsrLclIdx() {
		return usrLclIdx;
	}

	/**
	 * @param usrLclIdx the usrLclIdx to set
	 */
	public void setUsrLclIdx(int usrLclIdx) {
		this.usrLclIdx = usrLclIdx;
	}
	
	@Override
	public void reset() {
		this.usrAttrMap = new HashMap<>();
		this.sbj = null;
		this.grpPrps = null;
		this.sssId = null;
		this.cltIp = null;
		this.chan = null;
		this.usrLcl = Locale.ENGLISH;
		this.usrLclIdx = 0;
		
		try {
			if (null != loginCtx) {
				loginCtx.logout();
			}
		} catch (Exception ex) {
			// Ignore if failed to logout
		}
		
		loginCtx = null;
	}
	
	@Override
	public UsrCtx cloneUsrCtx() {
		try {
			return (UsrCtx) this.clone();
		} catch (CloneNotSupportedException ex) {
			throw new SvcException(ex);
		}
	}
	
	@Override
	public Map<String, String> getAppCtxMap() {
		return appCtxMap;
	}
	
}
