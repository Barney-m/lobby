package com.stx.centre.core.environment;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.stx.workshop.util.BaseEnvUtil;

public class ServletWebServerApplicationContext extends AnnotationConfigServletWebServerApplicationContext {
	public ServletWebServerApplicationContext() {}
	
	/**
	 * The environment instance set into BaseEnvUtilenvironment is an empty environment object
	 */
	@Override
	protected void initPropertySources() {
		super.initPropertySources();
		ConfigurableEnvironment env = getEnvironment();
		env.setDefaultProfiles("SPRING_PROFILES_DEFAULT", "PROD");
		
		BaseEnvUtil.setStaticEnv(env);
	}
}
