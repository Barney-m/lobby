package com.stx.centre.security.web.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.security.user.bean.CtrUsr;

public class CtrIamRegisterRsp {

	protected String status;
	
	protected CtrUsr registerRsp;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonGetter("result")
	public CtrUsr getRegisterRsp() {
		return registerRsp;
	}

	public void setRegisterRsp(CtrUsr registerRsp) {
		this.registerRsp = registerRsp;
	}
	
}
