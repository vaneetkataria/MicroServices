package com.katariasoft.microservices.movieservice.web.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

//All property sources can be configured here for which beans are going to be defined one by one.
//@Configuration
public class DefaultSystemUserAsABeanConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "user")
	public DefaultSystemUserConfiguration defaultSystemUserConfiguration() {
		return new DefaultSystemUserConfiguration();
	}

}
