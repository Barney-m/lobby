package com.stx.centre.security.oauth2.web.svc.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.stx.centre.security.oauth2.web.svc.CtrAuthMntSvc;
import com.stx.centre.security.web.bean.CtrIamLoginRsp;
import com.stx.workshop.bean.ReqMap;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.exception.SvcException;
import com.stx.workshop.factory.ClassObjFactory;
import com.stx.workshop.factory.InvokeFactory;

@Service
public class CtrAuthMntSvcImpl implements CtrAuthMntSvc {
	
	@Resource
	InvokeFactory invokeFactory;
	
	/**
	 * Login Method
	 */
	public CtrIamLoginRsp login(String email, String pwd) {
		if (StringUtils.isBlank(email) || StringUtils.isBlank(pwd)) {
			throw new SvcException("Email / Password is required");
		}
		
		ReqMap reqMap = ClassObjFactory.newInstance(ReqMap.class);
		Map<String, Object> reqPmrMap = new HashMap<>();
		reqPmrMap.put("email", email);
		reqPmrMap.put("password", pwd);
		reqMap.setReqMap(reqPmrMap);
		CtrIamLoginRsp rsp = invokeFactory.invokePost(reqMap, "http://localhost:8190/centre/iam/auth/login", RestConst.ACPT_TYPE_X_WWW_FORM_URLENCODED, CtrIamLoginRsp.class);

		if (null != rsp) {
			return rsp;
		}
		
		return null;
	}
	
}
