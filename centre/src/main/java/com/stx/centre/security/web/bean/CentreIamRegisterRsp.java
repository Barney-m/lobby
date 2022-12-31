package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CentreUser;
import com.stx.workshop.rest.ErrRsp;

public class CentreIamRegisterRsp extends ErrRsp {
	
	protected CentreUser registerRsp;

	@JsonGetter("result")
	public CentreUser getRegisterRsp() {
		return registerRsp;
	}

	public void setRegisterRsp(CentreUser registerRsp) {
		this.registerRsp = registerRsp;
	}
	
}
