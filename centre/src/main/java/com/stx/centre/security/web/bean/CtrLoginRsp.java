package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CtrUsr;

public class CtrLoginRsp {

	protected String sssId;
	
	protected String acsTkn;
	
	protected String acsTknExpAt;
	
	protected String rfhTkn;
	
	protected String rfhTknExpAt;
	
	protected CtrUsr usr;

	@JsonGetter("session_id")
	public String getSssId() {
		return sssId;
	}

	public void setSssId(String sssId) {
		this.sssId = sssId;
	}

	@JsonGetter("access_token")
	public String getAcsTkn() {
		return acsTkn;
	}

	public void setAcsTkn(String acsTkn) {
		this.acsTkn = acsTkn;
	}

	@JsonGetter("access_token_expire_at")
	public String getAcsTknExpAt() {
		return acsTknExpAt;
	}

	public void setAcsTknExpAt(String acsTknExpAt) {
		this.acsTknExpAt = acsTknExpAt;
	}

	@JsonGetter("refresh_token")
	public String getRfhTkn() {
		return rfhTkn;
	}

	public void setRfhTkn(String rfhTkn) {
		this.rfhTkn = rfhTkn;
	}

	@JsonGetter("refresh_token_expire_at")
	public String getRfhTknExpAt() {
		return rfhTknExpAt;
	}

	public void setRfhTknExpAt(String rfhTknExpAt) {
		this.rfhTknExpAt = rfhTknExpAt;
	}

	@JsonGetter("user")
	public CtrUsr getUsr() {
		return usr;
	}

	public void setUsr(CtrUsr usr) {
		this.usr = usr;
	}
}
