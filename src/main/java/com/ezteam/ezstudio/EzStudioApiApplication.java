package com.ezteam.ezstudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @file EzStudioApiApplication.java
 * @description Main entry point for Spring boot project
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@SpringBootApplication
@EnableOAuth2Sso
public class EzStudioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzStudioApiApplication.class, args);
	}
}
