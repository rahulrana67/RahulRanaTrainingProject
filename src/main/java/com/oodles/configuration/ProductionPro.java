package com.oodles.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("pro")
public class ProductionPro{
@Bean
public EnvConfiguration getProductionConfig(){
	return new ProductionEnv();
	}
}