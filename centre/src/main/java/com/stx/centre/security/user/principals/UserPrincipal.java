package com.stx.centre.security.user.principals;

import java.io.Serializable;
import java.security.Principal;

public class UserPrincipal implements Principal, Serializable {

	private static final long serialVersionUID = 8379047605858649700L;

	private final String userId;
	
	private String email;
	
	private String fullName;
	
	
	public UserPrincipal(String id, String email) {
		this.userId = id;
		this.email = email;
	}
	
	public UserPrincipal(String id, String email, String fullName) {
		this.userId = id;
		this.email = email;
		this.fullName = fullName;
	}
	
	@Override
	public int hashCode() {
		return 31 + ((null == userId) ? 0 : userId.hashCode());
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;

		if (null == obj) return false;

		if (getClass() != obj.getClass()) return false;

		UserPrincipal other = (UserPrincipal) obj;
		if (null == userId) {
			if (null != other.userId) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * see {@link java.security.Principal#getName()}
	 * 
	 * @return usrId - User Id
	 */
	@Override
	public String getName() {
		return userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFullName() {
		return fullName;
	}
}
