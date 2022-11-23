package com.stx.centre.security.user.principals;

import java.io.Serializable;
import java.security.Principal;

public class UsrPrp implements Principal, Serializable {

	private static final long serialVersionUID = 8379047605858649700L;

	private final String usrId;
	
	private String email;
	
	private String fullNm;
	
	
	public UsrPrp(String id, String email) {
		this.usrId = id;
		this.email = email;
	}
	
	public UsrPrp(String id, String email, String fullNm) {
		this.usrId = id;
		this.email = email;
		this.fullNm = fullNm;
	}
	
	@Override
	public int hashCode() {
		return 31 + ((null == usrId) ? 0 : usrId.hashCode());
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;

		if (null == obj) return false;

		if (getClass() != obj.getClass()) return false;

		UsrPrp other = (UsrPrp) obj;
		if (null == usrId) {
			if (null != other.usrId) {
				return false;
			}
		} else if (!usrId.equals(other.usrId)) {
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
		return usrId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFullNm() {
		return fullNm;
	}
}
