package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.workshop.rest.ErrRsp;

public class CtrIamLoginRsp extends ErrRsp {
	
	protected CtrLoginRsp loginRsp;

	@JsonGetter("result")
	public CtrLoginRsp getLoginRsp() {
		return loginRsp;
	}

	public void setLoginRsp(CtrLoginRsp loginRsp) {
		this.loginRsp = loginRsp;
	}
	
}
