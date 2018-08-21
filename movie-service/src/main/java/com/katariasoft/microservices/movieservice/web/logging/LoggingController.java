package com.katariasoft.microservices.movieservice.web.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	/*
	 * private static final Logger logger = LoggerFactory .getLogger(
	 * "com.katariasoft.microservices.movieservice.web.logging.LoggingController");
	 */

	private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@GetMapping(path = "/log/default")
	public void logDefaults() {

		logger.trace("This is trace level log for {}", "trace");
		logger.debug("This is debug level log for {}", "debug");
		logger.info("This is info level log for {}", "info");
		logger.warn("This is warn level log for {}", "warn");
		logger.error("This is error level log for {}", "error");

	}

}
