package com.stx.centre.security.oauth2.web.rest;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stx.centre.security.oauth2.web.rest.constant.CentreAuthRestConst;
import com.stx.centre.security.oauth2.web.svc.CentreAuthMntSvc;
import com.stx.centre.security.user.bean.CentreUser;
import com.stx.centre.security.web.bean.CentreIamLoginRsp;
import com.stx.centre.security.web.bean.CentreIamRegisterReq;
import com.stx.centre.security.web.bean.CentreIamRegisterRsp;
import com.stx.centre.security.web.bean.CentreLoginRsp;
import com.stx.workshop.exception.SvcException;
import com.stx.workshop.factory.ClassObjFactory;

@RestController
@RequestMapping(CentreAuthRestConst.CTR_AUTH_ENDPOINT)
public class CentreAuthRest {
	
	@Autowired
	CentreAuthMntSvc centreAuthMntSvc;
	
	@PostMapping(CentreAuthRestConst.CTR_AUTH_LOGIN_ENDPOINT)
	public CentreLoginRsp loginReq(@RequestParam String email, @RequestParam String password) {
		CentreIamLoginRsp rsp = centreAuthMntSvc.login(email, password);
		
		if (null == rsp || !StringUtils.equals(rsp.getStatus(), "200")
							|| null == rsp.getLoginRsp()) {
			throw new SvcException("Failed to Login");
		}
		
		return rsp.getLoginRsp();
	}
	
	@PostMapping(CentreAuthRestConst.CTR_AUTH_REGISTER_ENDPOINT)
	public CentreUser registerReq(@RequestBody CentreIamRegisterReq req) {
		CentreIamRegisterRsp rsp = centreAuthMntSvc.register(req);
		
		if (null == rsp || !StringUtils.equals(rsp.getStatus(), "200")
							|| null == rsp.getRegisterRsp()) {
			throw new SvcException("Failed to Register");
		}
		
		return rsp.getRegisterRsp();
	}
	
	@PostMapping("/abc")
	public CentreUser registerReq() {
		return ClassObjFactory.newInstance(CentreUser.class);
	}
}
