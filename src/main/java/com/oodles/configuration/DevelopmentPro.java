package com.oodles.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("dev")

public class DevelopmentPro {
	@Bean
	public EnvConfiguration getDevelopmentConfig(){
		return new DevelopmentEnv();
	}

}