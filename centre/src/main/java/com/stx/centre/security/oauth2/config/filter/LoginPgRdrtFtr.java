package com.stx.centre.security.oauth2.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.stx.centre.security.oauth2.config.strategy.SameHostRedirectStrategy;
import com.stx.workshop.util.PropertyUtil;

public class LoginPgRdrtFtr extends OncePerRequestFilter {
	private RequestMatcher loginPgReqMtch;
	
	private RedirectStrategy rdrtSttg;
	
	// Server Rendering
	public LoginPgRdrtFtr() {
		if (PropertyUtil.isCustomURL()) {
			rdrtSttg = new SameHostRedirectStrategy();
		} else {
			rdrtSttg = new DefaultRedirectStrategy();
		}
		
		loginPgReqMtch = new OrRequestMatcher(new AntPathRequestMatcher("/login"));
	}
	
	/**
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilter(javax.servlet.ServletRequest,
	 * 		javax.servlet.ServletResponse, FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
			FilterChain ftrChain) throws ServletException, IOException {
		if (loginPgReqMtch.matches(req)) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if (null != auth && auth.isAuthenticated()) {
				rdrtSttg.sendRedirect(req, res, "/home");
				return;
			}
		}
		
		ftrChain.doFilter(req, res);
	}
}
