package com.katariasoft.microservices.movieservice.web.nosqldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katariasoft.microservices.movieservice.web.nosqldb.config.RedisConfiguration;

@RestController
public class NoSqlDBConfigurationProviderService {

	@Autowired
	private RedisConfiguration redis;

	@GetMapping("/configurations/nosqldbs/redis")
	public ResponseEntity<String> getRedisConfiguration() {
		return ResponseEntity.ok().body(redis.getHost()+" "+ redis.getPort() + " "+ redis.getPassword());
	}

}
