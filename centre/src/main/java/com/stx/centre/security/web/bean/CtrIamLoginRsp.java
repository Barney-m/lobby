package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CtrUsr;

public class CtrIamLoginRsp {

	protected String status;
	
	protected CtrLoginRsp loginRsp;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonGetter("result")
	public CtrLoginRsp getLoginRsp() {
		return loginRsp;
	}

	public void setLoginRsp(CtrLoginRsp loginRsp) {
		this.loginRsp = loginRsp;
	}
	
}
