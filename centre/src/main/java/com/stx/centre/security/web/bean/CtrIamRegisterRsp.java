package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.workshop.rest.ErrRsp;

public class CtrIamRegisterRsp extends ErrRsp {
	
	protected CtrUsr registerRsp;

	@JsonGetter("result")
	public CtrUsr getRegisterRsp() {
		return registerRsp;
	}

	public void setRegisterRsp(CtrUsr registerRsp) {
		this.registerRsp = registerRsp;
	}
	
}
