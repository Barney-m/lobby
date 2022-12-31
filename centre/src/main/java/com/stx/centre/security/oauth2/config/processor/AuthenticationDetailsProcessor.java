package com.stx.centre.security.oauth2.config.processor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationDetailsSource;

import com.stx.centre.security.oauth2.config.AuthenticationDetails;
import com.stx.workshop.factory.ClassObjFactory;

public class AuthenticationDetailsProcessor implements AuthenticationDetailsSource<HttpServletRequest, AuthenticationDetails> {
	public static final String REQ_PMR_FRC_LOGOUT = "forceLogout";
	
	private final String[] additionalParamNames;
	
	private final String[] loginOptionParamNames;
	
	public AuthenticationDetailsProcessor() {
		super();
		this.additionalParamNames = null;
		this.loginOptionParamNames = null;
	}
	
	@Override
	public AuthenticationDetails buildDetails(HttpServletRequest req) {
		AuthenticationDetails processor = ClassObjFactory.newInstance(AuthenticationDetails.class);
		
		String val = null;
		if (StringUtils.isNotBlank(val)) {
			processor.setRemoteAddr(req.getRemoteAddr());
		}
		
		String forceLogoutIdc = req.getParameter(REQ_PMR_FRC_LOGOUT);
		processor.setForceLogout("Y".equals(forceLogoutIdc));
		
		HttpSession session = req.getSession(false);
		processor.setSessionId(session.getId());
		
		List<String> reqParamNames = Collections.list(req.getParameterNames());
		
		processor.setAdditionalParams(Collections.unmodifiableMap(extractedFromParameter(req, this.additionalParamNames, reqParamNames)));
		
		Map<String, String> loginOptions = extractedFromParameter(req, this.loginOptionParamNames, reqParamNames);
		
		if (processor.getIsForceLogout()) {
			loginOptions.put("autoLogout", "Y");
		}
		
		loginOptions.put("ipAddress", processor.getRemoteAddr());
		processor.setLoginOptions(Collections.unmodifiableMap(loginOptions));
		return processor;
	}
	
	private Map<String, String> extractedFromParameter(HttpServletRequest req, String[] paramNames, List<String> reqParamNames) {
		Map<String, String> params = new HashMap<>();
		
		if (null != paramNames) {
			for (String param : paramNames) {
				if (reqParamNames.contains(param)) {
					params.put(param, req.getParameter(param));
				}
			}
		}
		
		return params;
	}
}
