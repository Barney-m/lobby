package com.stx.centre.security.oauth2.config.processor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.stx.centre.security.oauth2.config.strategy.SameHostRedirectStrategy;

public class LoginUrlAuthenticationEntryPointProcessor extends LoginUrlAuthenticationEntryPoint {
	RedirectStrategy redirectStrategy = new SameHostRedirectStrategy();
	
	public LoginUrlAuthenticationEntryPointProcessor(String loginFormUrl) {
		super(loginFormUrl);
	}
	
	/**
	 * Performs Redirect to Login Form URL
	 */
	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException authEx) throws IOException, ServletException {
		String redirectUrl = buildRedirectUrlToLoginPage(req, res, authEx);
		redirectStrategy.sendRedirect(req, res, redirectUrl);
	}
}
