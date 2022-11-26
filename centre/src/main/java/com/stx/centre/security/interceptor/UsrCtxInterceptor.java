package com.stx.centre.security.interceptor;

import java.util.Enumeration;
import java.util.UUID;

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

import com.stx.centre.security.UsrCtxUtil;
import com.stx.centre.security.user.SysUsrCtx;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.interceptor.LoggerInterceptor;

@Component
public class UsrCtxInterceptor implements HandlerInterceptor {

	private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	private static ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    
		String usrId = request.getHeader("usrId");

	    String email = request.getHeader("email");
	    if (null == email) {
	    	email = UsrCtxUtil.SYSTEM_EMAIL;
	    }
	    
	    String reqId = request.getHeader("reqId");
	    
	    String remoteAddr = request.getHeader("ipAddr");
	    if (StringUtils.isBlank(remoteAddr)) {
	    	remoteAddr = request.getRemoteAddr();
	    }
	    
	    SysUsrCtx usrCtx = new SysUsrCtx(email, null, remoteAddr);
	    UsrCtxUtil.setUsrCtx(usrCtx);
	    
	    if (StringUtils.isNotBlank(reqId)) {
	    	UsrCtxUtil.setThrId(reqId);
	    }
	    
	    String[] authHdr = StringUtils.split(request.getHeader(RestConst.REQ_HDR_AUTH), " ");
	    if (!CollectionUtils.sizeIsEmpty(authHdr) && authHdr.length >= 2 && StringUtils.isNotBlank(authHdr[1])) {
	    	usrCtx.setUsrAttrMap("acsTkn", authHdr[1]);
	    }
	    
	    // TODO: App Context Map Logic
	    
	    // TODO: Locale Logic
	    
	    // JBOSS Logging
	    MDC.put("reqId", reqId);
	    MDC.put("emai", email);
	    MDC.put("ipAddr", remoteAddr);
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
	    	UsrCtxUtil.setUsrCtx(null);
	    } finally {
	    	// Kills Thread
	    	startTime.remove();
	    }
	}
}
