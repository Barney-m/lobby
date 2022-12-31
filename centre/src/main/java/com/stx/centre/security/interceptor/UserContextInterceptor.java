package com.stx.centre.security.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.stx.centre.security.UserContextUtil;
import com.stx.centre.security.user.SystemUserContext;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.interceptor.LoggerInterceptor;

@Component
public class UserContextInterceptor implements HandlerInterceptor {

	private static Logger log = LoggerFactory.getLogger(UserContextInterceptor.class);
	
	private static ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    
		String userId = request.getHeader("userId");

	    String email = request.getHeader("email");
	    if (null == email) {
	    	email = UserContextUtil.SYSTEM_EMAIL;
	    }
	    
	    String reqId = request.getHeader("reqId");
	    
	    String remoteAddr = request.getHeader("ipAddress");
	    if (StringUtils.isBlank(remoteAddr)) {
	    	remoteAddr = request.getRemoteAddr();
	    }
	    
	    SystemUserContext userContext = new SystemUserContext(email, null, remoteAddr);
	    UserContextUtil.setUserContext(userContext);
	    
	    if (StringUtils.isNotBlank(reqId)) {
	    	UserContextUtil.setThreadId(reqId);
	    }
	    
	    String[] authHeader = StringUtils.split(request.getHeader(RestConst.REQ_HDR_AUTH), " ");
	    if (null != authHeader && authHeader.length >= 2 && StringUtils.isNotBlank(authHeader[1])) {
	    	userContext.setUserAttrMap("accessToken", authHeader[1]);
	    }
	    
	    // TODO: App Context Map Logic
	    
	    // TODO: Locale Logic
	    
	    // JBOSS Logging
	    MDC.put("reqId", reqId);
	    MDC.put("email", email);
	    MDC.put("ipAddress", remoteAddr);
	    MDC.put("uri", request.getRequestURI());
	    
	    startTime.set(System.currentTimeMillis());
	    return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
	    try {
	    	long elapsed = System.currentTimeMillis() - startTime.get().longValue();
	    	log.debug(elapsed + " ms");
	    	UserContextUtil.setUserContext(null);
	    } finally {
	    	// Kills Thread
	    	startTime.remove();
	    }
	}
}
