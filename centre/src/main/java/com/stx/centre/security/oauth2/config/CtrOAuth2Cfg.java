package com.stx.centre.security.oauth2.config;

import org.springframework.context.annotation.Bean;

import com.stx.centre.security.oauth2.config.filter.LoginPgRdrtFtr;

public class CtrOAuth2Cfg {
	@Bean
	public LoginPgRdrtFtr loginPgRdrtFtr() {
		return new LoginPgRdrtFtr();
	}
}
