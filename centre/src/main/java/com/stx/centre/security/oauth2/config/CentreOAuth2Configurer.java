package com.stx.centre.security.oauth2.config;

import org.springframework.context.annotation.Bean;

import com.stx.centre.security.oauth2.config.filter.LoginPageRedirectFilter;

public class CentreOAuth2Configurer {
	@Bean
	public LoginPageRedirectFilter loginPageRedirectFilter() {
		return new LoginPageRedirectFilter();
	}
}
