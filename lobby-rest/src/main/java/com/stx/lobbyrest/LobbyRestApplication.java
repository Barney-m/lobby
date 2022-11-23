package com.stx.lobbyrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@ComponentScan({"com.stx.lobbyservice", "com.stx.lobbyrest.*", "com.stx.workshop"})
public class LobbyRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LobbyRestApplication.class, args);
	}

}
