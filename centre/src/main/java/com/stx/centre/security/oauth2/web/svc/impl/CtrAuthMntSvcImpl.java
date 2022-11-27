package com.stx.centre.security.oauth2.web.svc.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.stx.centre.security.oauth2.web.svc.CtrAuthMntSvc;
import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.centre.security.web.bean.CtrIamLoginRsp;
import com.stx.centre.security.web.bean.CtrIamRegisterReq;
import com.stx.centre.security.web.bean.CtrIamRegisterRsp;
import com.stx.workshop.bean.ReqMap;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.exception.SvcException;
import com.stx.workshop.factory.ClassObjFactory;
import com.stx.workshop.factory.InvokeFactory;
import com.stx.workshop.util.DateUtil;

@Service
public class CtrAuthMntSvcImpl implements CtrAuthMntSvc {
	
	public static final String IAM_SERVER_URI = "http://localhost:8190/centre/iam/auth";
	
	public static final String IAM_SERVER_LOGIN_URI = IAM_SERVER_URI + "/login";
	
	public static final String IAM_SERVER_REGISTER_URI = IAM_SERVER_URI + "/register";
	
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
		CtrIamLoginRsp rsp = invokeFactory.invokePost(reqMap, IAM_SERVER_LOGIN_URI,
									RestConst.ACPT_TYPE_X_WWW_FORM_URLENCODED, CtrIamLoginRsp.class);

		if (null != rsp) {
			return rsp;
		}
		
		return null;
	}
	
	/**
	 * Register Method
	 */
	public CtrIamRegisterRsp register(CtrIamRegisterReq req) {
		if (null == req || StringUtils.isBlank(req.getEmail())
				|| StringUtils.isBlank(req.getPwd()) || StringUtils.isBlank(req.getFullNm())) {
			throw new SvcException("Missing Fields");
		}
		
		ReqMap reqMap = ClassObjFactory.newInstance(ReqMap.class);
		Map<String, Object> reqPmrMap = new HashMap<>();
		reqPmrMap.put("email", req.getEmail());
		reqPmrMap.put("password", req.getPwd());
		reqPmrMap.put("full_name", req.getFullNm());
		reqPmrMap.put("address", req.getAddr());
		reqPmrMap.put("dob", DateUtil.parseSqlDate(req.getDob()));
		reqPmrMap.put("mobile_no", req.getMblNo());
		reqPmrMap.put("rank", null);
		reqMap.setReqMap(reqPmrMap);
		CtrIamRegisterRsp rsp = invokeFactory.invokePost(reqMap, IAM_SERVER_REGISTER_URI,
									RestConst.ACPT_TYPE_X_WWW_FORM_URLENCODED, CtrIamRegisterRsp.class);

		if (null != rsp) {
			return rsp;
		}
		
		return null;
	}
	
}
