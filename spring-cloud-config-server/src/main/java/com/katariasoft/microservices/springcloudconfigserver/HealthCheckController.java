package com.katariasoft.microservices.springcloudconfigserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/checkHealth")
	public String checkHealth() {
		return "OK";
	}

}
