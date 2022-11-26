package com.stx.centre.security.oauth2.config.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.context.SecurityContextRepository;

import com.stx.centre.security.oauth2.config.filter.LoginPgRdrtFtr;
import com.stx.centre.security.oauth2.config.processor.AuthenticationDetailsProcessor;
import com.stx.centre.security.oauth2.config.processor.LoginUrlAuthenticationEntryPointProcessor;
import com.stx.workshop.util.PropertyUtil;

public class OAuth2LoginHttpConfigurer extends
		AbstractHttpConfigurer<OAuth2LoginHttpConfigurer, HttpSecurity> implements Ordered {
	public static final int ORDER = AuthorizeRequestHttpConfigurer.ORDER + 5;
	
	@Autowired
	protected SecurityContextRepository securityContextRepository;
	
	@Autowired
	protected LoginPgRdrtFtr loginPageRedirectFilter;
	
	@Autowired
	protected AuthenticationDetailsProcessor authenticationDetailsProcessor;
	
	@Autowired
	protected AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	protected LogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	protected LogoutHandler logoutHandler;
	
	@Autowired
	protected AuthenticationEventPublisher authenticationEventPublisher;
	
	@Override
	public int getOrder() {
		return ORDER;
	}
	
	@Override
	public void init(HttpSecurity http) throws Exception {
		http.securityContext(secCtx -> secCtx.securityContextRepository(securityContextRepository))
			.formLogin(ctx -> ctx.authenticationDetailsSource(authenticationDetailsProcessor)
					.permitAll()
					.usernameParameter("email")
					.passwordParameter("password")
					.successHandler(authenticationSuccessHandler)
					.failureHandler(authenticationFailureHandler))
			.logout(ctx -> ctx.logoutUrl("/logout")
					.permitAll()
					.logoutSuccessHandler(logoutSuccessHandler)
					.deleteCookies("sessionId")
					.addLogoutHandler(logoutHandler)
					.invalidateHttpSession(true)
					.clearAuthentication(true))
			.exceptionHandling(ctx -> {
				if (PropertyUtil.isCustomURL()) {
					ctx.authenticationEntryPoint(new LoginUrlAuthenticationEntryPointProcessor("/login"));
				} else {
					ctx.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
				}
			});
		
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.parentAuthenticationManager(null);
		authenticationManagerBuilder.authenticationEventPublisher(authenticationEventPublisher);
	}
}
