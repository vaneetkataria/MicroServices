package com.katariasoft.microservices.springcloudeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaNamingServerApplication.class, args);
	}
}
