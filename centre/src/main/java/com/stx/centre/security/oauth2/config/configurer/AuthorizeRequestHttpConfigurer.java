package com.stx.centre.security.oauth2.config.configurer;

import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

public class AuthorizeRequestHttpConfigurer extends
		AbstractHttpConfigurer<AuthorizeRequestHttpConfigurer, HttpSecurity> implements Ordered {
	
	public static final int ORDER = 0;
	
	@Override
	public int getOrder() {
		return ORDER;
	}
	
	@Override
	public void init(HttpSecurity http) throws Exception {
		http.authorizeRequests(r -> r.antMatchers(getSecurityPermitPaths())
				.permitAll()
				.antMatchers("stx-rest/public/sss")
				.authenticated()
				.anyRequest()
				.authenticated());
	}
	
	protected String[] getSecurityPermitPaths() {
		return new String[] {
				"/login", "/forgot-password", "/reset-password", "/stx-rest/public", "/oauth/redirect"
		};
	}
}
