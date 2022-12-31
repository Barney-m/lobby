package com.stx.centre.security.oauth2.web.svc.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.stx.centre.security.oauth2.web.svc.CentreAuthMntSvc;
import com.stx.centre.security.user.bean.CentreUser;
import com.stx.centre.security.web.bean.CentreIamLoginRsp;
import com.stx.centre.security.web.bean.CentreIamRegisterReq;
import com.stx.centre.security.web.bean.CentreIamRegisterRsp;
import com.stx.workshop.bean.ReqMap;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.exception.SvcException;
import com.stx.workshop.factory.ClassObjFactory;
import com.stx.workshop.factory.InvokeFactory;
import com.stx.workshop.util.DateUtil;

@Service
public class CentreAuthMntSvcImpl implements CentreAuthMntSvc {
	
	public static final String IAM_SERVER_URI = "http://localhost:8190/centre/iam/auth";
	
	public static final String IAM_SERVER_LOGIN_URI = IAM_SERVER_URI + "/login";
	
	public static final String IAM_SERVER_REGISTER_URI = IAM_SERVER_URI + "/register";
	
	@Resource
	InvokeFactory invokeFactory;
	
	/**
	 * Login Method
	 */
	public CentreIamLoginRsp login(String email, String pwd) {
		if (StringUtils.isBlank(email) || StringUtils.isBlank(pwd)) {
			throw new SvcException("Email / Password is required");
		}
		
		ReqMap reqMap = ClassObjFactory.newInstance(ReqMap.class);
		Map<String, Object> reqParamMap = new HashMap<>();
		reqParamMap.put("email", email);
		reqParamMap.put("password", pwd);
		reqMap.setReqMap(reqParamMap);
		CentreIamLoginRsp rsp = invokeFactory.invokePost(reqMap, IAM_SERVER_LOGIN_URI,
									RestConst.ACPT_TYPE_X_WWW_FORM_URLENCODED, CentreIamLoginRsp.class);

		return null != rsp ? rsp : null;
	}
	
	/**
	 * Register Method
	 */
	public CentreIamRegisterRsp register(CentreIamRegisterReq req) {
		if (null == req || StringUtils.isBlank(req.getEmail())
				|| StringUtils.isBlank(req.getPassword()) || StringUtils.isBlank(req.getFullName())) {
			throw new SvcException("Missing Fields");
		}
		
		ReqMap reqMap = ClassObjFactory.newInstance(ReqMap.class);
		Map<String, Object> reqParamMap = new HashMap<>();
		reqParamMap.put("email", req.getEmail());
		reqParamMap.put("password", req.getPassword());
		reqParamMap.put("fullName", req.getFullName());
		reqParamMap.put("address", req.getAddress());
		reqParamMap.put("dob", null != req.getDob() ? DateUtil.parseSqlDate(req.getDob()) : null);
		reqParamMap.put("mobileNo", req.getMobileNo());
		reqParamMap.put("rank", null);
		reqMap.setReqMap(reqParamMap);
		CentreIamRegisterRsp rsp = invokeFactory.invokePost(reqMap, IAM_SERVER_REGISTER_URI,
									RestConst.ACPT_TYPE_X_WWW_FORM_URLENCODED, CentreIamRegisterRsp.class);

		return null != rsp ? rsp : null;
	}
	
}
