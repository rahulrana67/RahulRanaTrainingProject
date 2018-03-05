package com.oodles.configuration;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Parameter;

@Configuration
@EnableSwagger2

public class SwaggerConfig {


	@Bean
	public Docket api() {
	//Adding Header
	ParameterBuilder aParameterBuilder = new ParameterBuilder();
	aParameterBuilder.name("headerName").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
	List<Parameter> aParameters = new ArrayList<Parameter>();
	aParameters.add(aParameterBuilder.build());
	return new Docket(DocumentationType.SWAGGER_2).select()
	.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo()).pathMapping("/").globalOperationParameters(aParameters);
	}

	


 private ApiInfo apiInfo() {
 return new ApiInfoBuilder()
 .title("Test Project")
 .description("Test Application")
 .contact(new Contact("Ekesh", "http://test.me", "test@gmail.com"))
 .version("1.0")
 .build();
 }

 }
