package com.katariasoft.microservices.movieservice.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katariasoft.microservices.movieservice.web.user.config.DefaultSystemUserConfiguration;

@RestController
public class UserConfigurationProviderService {

	@Autowired
	private DefaultSystemUserConfiguration user;

	@GetMapping("/configurations/users/default")
	public ResponseEntity<String> getUserConbfiguration() {

		return ResponseEntity.ok()
				.body(user.getGoodName() + " " + user.getClazz() + " " + user.getSubjects() + " " + user.getProjects()
						+ " " + user.getCredentials() + " " + user.getAddress() + " " + user.getFavourite() + " "
						+ user.getFavouriteMap() + " " + user.getContacts());

	}

}
