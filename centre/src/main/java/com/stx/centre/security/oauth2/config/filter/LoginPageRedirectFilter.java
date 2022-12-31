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

public class LoginPageRedirectFilter extends OncePerRequestFilter {
	private RequestMatcher loginPageRequestMatch;
	
	private RedirectStrategy redirectStrategy;
	
	// Server Rendering
	public LoginPageRedirectFilter() {
		if (PropertyUtil.isCustomURL()) {
			redirectStrategy = new SameHostRedirectStrategy();
		} else {
			redirectStrategy = new DefaultRedirectStrategy();
		}
		
		loginPageRequestMatch = new OrRequestMatcher(new AntPathRequestMatcher("/login"));
	}
	
	/**
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilter(javax.servlet.ServletRequest,
	 * 		javax.servlet.ServletResponse, FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
			FilterChain filterChain) throws ServletException, IOException {
		if (loginPageRequestMatch.matches(req)) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if (null != auth && auth.isAuthenticated()) {
				redirectStrategy.sendRedirect(req, res, "/home");
				return;
			}
		}
		
		filterChain.doFilter(req, res);
	}
}
