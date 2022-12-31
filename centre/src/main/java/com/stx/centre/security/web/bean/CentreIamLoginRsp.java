package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CentreUser;
import com.stx.workshop.rest.ErrRsp;

public class CentreIamLoginRsp extends ErrRsp {
	
	protected CentreLoginRsp loginRsp;

	@JsonGetter("result")
	public CentreLoginRsp getLoginRsp() {
		return loginRsp;
	}

	public void setLoginRsp(CentreLoginRsp loginRsp) {
		this.loginRsp = loginRsp;
	}
	
}
