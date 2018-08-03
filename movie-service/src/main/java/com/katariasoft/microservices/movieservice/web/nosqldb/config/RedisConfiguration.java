package com.katariasoft.microservices.movieservice.web.nosqldb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/properties/nosqldb/redis/redisConnection_${environment}.properties")
public class RedisConfiguration {

	@Autowired
	private Environment environment;

	@Value("${redis.host}")
	private String host;

	private String port;

	private String password;

	@PostConstruct
	public void initProperties() {
		port = environment.getProperty("redis.port");
		password = environment.getProperty("redis.password");
	}

	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
	}
}
