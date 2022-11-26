package com.stx.centre.security.oauth2.web.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stx.centre.security.oauth2.web.rest.constant.CtrAuthRestConst;
import com.stx.centre.security.oauth2.web.svc.CtrAuthMntSvc;
import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.centre.security.web.bean.CtrIamLoginRsp;
import com.stx.centre.security.web.bean.CtrLoginRsp;
import com.stx.workshop.exception.SvcException;

@RestController
@RequestMapping(CtrAuthRestConst.CTR_AUTH_ENDPOINT)
public class CtrAuthRest {
	
	@Autowired
	CtrAuthMntSvc ctrAuthMntSvc;
	
	@PostMapping(CtrAuthRestConst.CTR_AUTH_LOGIN_ENDPOINT)
	public CtrLoginRsp loginReq(@RequestParam String email, @RequestParam String password) {
		CtrIamLoginRsp rsp = ctrAuthMntSvc.login(email, password);
		
		if (!rsp.getStatus().equals("200") && null == rsp.getLoginRsp()) {
			throw new SvcException("Failed to Login");
		}
		
		return rsp.getLoginRsp();
	}
	
	@GetMapping("/abc")
	public BigDecimal findAllUsr() {
		BigDecimal a = new BigDecimal("10");
		BigDecimal b = new BigDecimal("20");
		return a.pow(2);
	}
}
