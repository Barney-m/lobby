package com.stx.centre.security.oauth2.web.rest;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stx.centre.security.oauth2.web.rest.constant.CtrAuthRestConst;
import com.stx.centre.security.oauth2.web.svc.CtrAuthMntSvc;
import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.centre.security.web.bean.CtrIamLoginRsp;
import com.stx.centre.security.web.bean.CtrIamRegisterReq;
import com.stx.centre.security.web.bean.CtrIamRegisterRsp;
import com.stx.centre.security.web.bean.CtrLoginRsp;
import com.stx.workshop.exception.SvcException;
import com.stx.workshop.factory.ClassObjFactory;

@RestController
@RequestMapping(CtrAuthRestConst.CTR_AUTH_ENDPOINT)
public class CtrAuthRest {
	
	@Autowired
	CtrAuthMntSvc ctrAuthMntSvc;
	
	@PostMapping(CtrAuthRestConst.CTR_AUTH_LOGIN_ENDPOINT)
	public CtrLoginRsp loginReq(@RequestParam String email, @RequestParam String password) {
		CtrIamLoginRsp rsp = ctrAuthMntSvc.login(email, password);
		
		if (null == rsp || !StringUtils.equals(rsp.getStatus(), "200")
							|| null == rsp.getLoginRsp()) {
			throw new SvcException("Failed to Login");
		}
		
		return rsp.getLoginRsp();
	}
	
	@PostMapping(CtrAuthRestConst.CTR_AUTH_REGISTER_ENDPOINT)
	public CtrUsr registerReq(@RequestBody CtrIamRegisterReq req) {
		CtrIamRegisterRsp rsp = ctrAuthMntSvc.register(req);
		
		if (null == rsp || !StringUtils.equals(rsp.getStatus(), "200")
							|| null == rsp.getRegisterRsp()) {
			throw new SvcException("Failed to Register");
		}
		
		return rsp.getRegisterRsp();
	}
	
	@PostMapping("/abc")
	public CtrUsr registerReq() {
		return ClassObjFactory.newInstance(CtrUsr.class);
	}
}
