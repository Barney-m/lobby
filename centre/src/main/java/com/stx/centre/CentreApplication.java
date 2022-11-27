package com.stx.centre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.stx.centre.core.environment.ServletWebServerApplicationContext;

import io.micrometer.core.instrument.MeterRegistry.Config;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@ComponentScan({"com.stx.centre.*", "com.stx.workshop"})
public class CentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentreApplication.class, args);
		
		try (ServletWebServerApplicationContext ctx = new ServletWebServerApplicationContext(Config.class)) {
			ctx.initPropertySources();
		} catch (Exception ex) {
			// Do nothing...
		}
	}

}
