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
	public static final String REQ_PMR_FRC_LOGOUT = "frcLogout";
	
	private final String[] adlPmrNms;
	
	private final String[] loginOptPmrNms;
	
	public AuthenticationDetailsProcessor() {
		super();
		this.adlPmrNms = null;
		this.loginOptPmrNms = null;
	}
	
	@Override
	public AuthenticationDetails buildDetails(HttpServletRequest req) {
		AuthenticationDetails processor = ClassObjFactory.newInstance(AuthenticationDetails.class);
		
		String val = null;
		if (StringUtils.isNotBlank(val)) {
			processor.setRemoteAddr(req.getRemoteAddr());
		}
		
		String frcLogoutIdc = req.getParameter(REQ_PMR_FRC_LOGOUT);
		processor.setFrcLogout("Y".equals(frcLogoutIdc));
		
		HttpSession sss = req.getSession(false);
		processor.setSssId(sss.getId());
		
		List<String> reqPmrNms = Collections.list(req.getParameterNames());
		
		processor.setAdlPmrs(Collections.unmodifiableMap(extractedFromParameter(req, this.adlPmrNms, reqPmrNms)));
		
		Map<String, String> loginOpts = extractedFromParameter(req, this.loginOptPmrNms, reqPmrNms);
		
		if (processor.isFrcLogout()) {
			loginOpts.put("autoLogout", "Y");
		}
		
		loginOpts.put("ipAddr", processor.getRemoteAddr());
		processor.setLoginOpts(Collections.unmodifiableMap(loginOpts));
		return processor;
	}
	
	private Map<String, String> extractedFromParameter(HttpServletRequest req, String[] pmrNms, List<String> reqPmrNms) {
		Map<String, String> pmrs = new HashMap<>();
		
		if (null != pmrNms) {
			for (String pmr : pmrNms) {
				if (reqPmrNms.contains(pmr)) {
					pmrs.put(pmr, req.getParameter(pmr));
				}
			}
		}
		
		return pmrs;
	}
}
