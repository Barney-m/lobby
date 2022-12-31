package com.stx.centre.security.user.principals;

import java.io.Serializable;
import java.security.Principal;

public class GroupPrincipal implements Principal, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1667473562684859167L;
	
	/**
	 * Group Code
	 */
	protected String groupCode;
	
	/**
	 * Initialize Group Principal
	 * 
	 * @param groupCode - Group Code
	 */
	public GroupPrincipal(String groupCode) {
		this.groupCode = groupCode;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 31 + ((null == groupCode) ? 0 : groupCode.hashCode());
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;

		if (null == obj) return false;

		if (getClass() != obj.getClass()) return false;

		GroupPrincipal other = (GroupPrincipal) obj;
		if (null == groupCode) {
			if (null != other.groupCode) {
				return false;
			}
		} else if (!groupCode.equals(other.groupCode)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * see {@link java.security.Principal#getName()}
	 * 
	 * @return groupCode - Group Code
	 */
	@Override
	public String getName() {
		return groupCode;
	}
}
