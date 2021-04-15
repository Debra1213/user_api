package com.tts.userapi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() 
    { 
        return new Docket(DocumentationType.SWAGGER_2) 
        	groupName("Version 1")	
        .select()                                  
        .apis(RequestHandlerSelectors.basePackage(com.tts.usersaip))             
        .paths(PathSelectors.any())                          
        .build();                                           
    }
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2) 
        	groupName("Version 2")	
        .select()                                  
        .apis(RequestHandlerSelectors.basePackage(com.tts.usersaip))             
        .paths(PathSelectors.any())                          
        .build();                                           
    }
}