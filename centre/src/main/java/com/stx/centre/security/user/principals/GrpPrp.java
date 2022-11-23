package com.stx.centre.security.user.principals;

import java.io.Serializable;
import java.security.Principal;

public class GrpPrp implements Principal, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1667473562684859167L;
	
	/**
	 * Group Code
	 */
	protected String grpCode;
	
	/**
	 * Initialize Group Principal
	 * 
	 * @param grpCode - Group Code
	 */
	public GrpPrp(String grpCode) {
		this.grpCode = grpCode;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 31 + ((null == grpCode) ? 0 : grpCode.hashCode());
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;

		if (null == obj) return false;

		if (getClass() != obj.getClass()) return false;

		GrpPrp other = (GrpPrp) obj;
		if (null == grpCode) {
			if (null != other.grpCode) {
				return false;
			}
		} else if (!grpCode.equals(other.grpCode)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * see {@link java.security.Principal#getName()}
	 * 
	 * @return grpCode - Group Code
	 */
	@Override
	public String getName() {
		return grpCode;
	}
}
