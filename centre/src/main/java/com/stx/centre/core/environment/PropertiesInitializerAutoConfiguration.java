package com.stx.centre.core.environment;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

@AutoConfiguration
@Lazy(false)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class PropertiesInitializerAutoConfiguration {
	/**
	 * This method is static due to warning message during start of applicationContext
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer (ConfigurableEnvironment env){
		PropertySourcesPlaceholderConfigurer pptCfg = new PropertySourcesPlaceholderConfigurer();
		pptCfg.setEnvironment(env);
		return pptCfg;
	}
}
