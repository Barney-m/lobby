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

import com.stx.centre.security.UserContext;
import com.stx.centre.security.user.principals.GroupPrincipal;
import com.stx.centre.security.user.principals.UserPrincipal;
import com.stx.workshop.exception.SvcException;

/**
 * @author Ken Shen
 * @version 1.0
 */
public class StxUserContext implements UserContext, Serializable{
	private static final long serialVersionUID = 5752788078420473251L;

	private Map<String, Object> userAttrMap = new HashMap<>();
	
	private Subject subject;
	
	private transient LoginContext loginContext;
	
	private Set<GroupPrincipal> groupPrincipals;
	
	private String sessionId;
	
	private String clientIp;
	
	private String channel;
	
	private transient Locale userLocale = Locale.ENGLISH;
	
	private String userLanguage = "en";
	
	private int userLocaleIndex = 0;
	
	private Map<String, String> appContextMap;
	
	/**
	 * Store Login Context After Login Successfully
	 * 
	 * @param loginCtx JAAS Login Context
	 */
	public void setLoginContext(LoginContext loginContext) {
		this.loginContext = loginContext;
		subject = loginContext.getSubject();
		
		if (subject != null) {
			groupPrincipals = new HashSet<>();
			
			for (Iterator<GroupPrincipal> principals = subject.getPrincipals(GroupPrincipal.class).iterator(); principals.hasNext();) {
				groupPrincipals.add(principals.next());
			}
		}
	}
	
	@Override
	public LoginContext getLoginContext() {
		return loginContext;
	}
	
	/**
	 * Get User ID
	 */
	@Override
	public String getUserId() {
		Set<UserPrincipal> users = subject.getPrincipals(UserPrincipal.class);
		
		if (!CollectionUtils.isEmpty(users)) {
			return users.iterator().next().getName();
		}
		
		return null;
	}
	
	/**
	 * Get User Email
	 */
	@Override
	public String getEmail() {
		Set<UserPrincipal> users = subject.getPrincipals(UserPrincipal.class);
		
		if (!CollectionUtils.isEmpty(users)) {
			return users.iterator().next().getEmail();
		}
		
		return null;
	}
	
	/**
	 * Get User Full Name
	 */
	@Override
	public String getFullName() {
		Set<UserPrincipal> users = subject.getPrincipals(UserPrincipal.class);
		
		if (!CollectionUtils.isEmpty(users)) {
			return users.iterator().next().getFullName();
		}
		
		return null;
	}
	
	@Override
	public Set<GroupPrincipal> getGroupPrincipals() {
		return groupPrincipals;
	}
	
	public void setGroupPrincipals(Set<GroupPrincipal> groupPrincipals) {
		this.groupPrincipals = groupPrincipals;
	}

	/**
	 * @return the usrAttrMap
	 */
	public Object getUserAttribute(String key) {
		return userAttrMap;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getUserAttribute(Class<T> returnClass) {
		return (T) userAttrMap.get(returnClass.getName());
	}

	/**
	 * @param userAttrMap the userAttrMap to set
	 */
	public void setUserAttributeMap(String key, Object val) {
		userAttrMap.put(key, val);
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
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
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the userLocale
	 */
	public Locale getUserLocale() {
		if (null == userLocale) {
			userLocale = Locale.ENGLISH;
		}
		
		return userLocale;
	}

	/**
	 * @param userLocale the userLocale to set
	 */
	public void setUserLocale(Locale userLocale) {
		this.userLocale = userLocale;
		// Code your logic for indexing supported locale here...
	}

	/**
	 * @return the userLanguage
	 */
	public String getUserLanguage() {
		return userLanguage;
	}

	/**
	 * @param userLanguage the userLanguage to set
	 */
	public void setUserLanguage(String userLanguage) {
		this.userLanguage = userLanguage;
	}

	/**
	 * @return the userLocaleIndex
	 */
	public int getUserLocaleIndex() {
		return userLocaleIndex;
	}

	/**
	 * @param userLocaleIndex the userLocaleIndex to set
	 */
	public void setUserLocaleIndex(int userLocaleIndex) {
		this.userLocaleIndex = userLocaleIndex;
	}
	
	@Override
	public void reset() {
		this.userAttrMap = new HashMap<>();
		this.subject = null;
		this.groupPrincipals = null;
		this.sessionId = null;
		this.clientIp = null;
		this.channel = null;
		this.userLocale = Locale.ENGLISH;
		this.userLocaleIndex = 0;
		
		try {
			if (null != loginContext) {
				loginContext.logout();
			}
		} catch (Exception ex) {
			// Ignore if failed to logout
		}
		
		loginContext = null;
	}
	
	@Override
	public UserContext cloneUserContext() {
		try {
			return (UserContext) this.clone();
		} catch (CloneNotSupportedException ex) {
			throw new SvcException(ex);
		}
	}

	@Override
	public Map<String, String> getAppContextMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
