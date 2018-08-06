package com.katariasoft.microservices.movieservice.web.user.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// If this is not defined default user prroperties will be picked up from
// application.properties
@PropertySource(value = "classpath:/properties/user/defaultUser.properties")
@ConfigurationProperties(prefix = "user")
public class DefaultSystemUserConfiguration {

	private String goodName;
	private String clazz;
	private List<String> subjects;
	private Map<String, String> projects;
	private Credentials credentials;
	private String address;
	// Relaxed Binding
	private Favourite favourite;
	// Complex Type Binding
	private Map<String, Favourite> favouriteMap;
	private List<Contact> contacts;

	/*
	 * @PostConstruct public void postConstruct() { System.out.println(this); }
	 */

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Map<String, String> getProjects() {
		return projects;
	}

	public void setProjects(Map<String, String> projects) {
		this.projects = projects;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Favourite getFavourite() {
		return favourite;
	}

	public void setFavourite(Favourite favourite) {
		this.favourite = favourite;
	}

	public Map<String, Favourite> getFavouriteMap() {
		return favouriteMap;
	}

	public void setFavouriteMap(Map<String, Favourite> favouriteMap) {
		this.favouriteMap = favouriteMap;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "DefaultSystemUserConfiguration [goodName=" + goodName + ", clazz=" + clazz + ", subjects=" + subjects
				+ ", projects=" + projects + ", credentials=" + credentials + ", address=" + address + ", favourite="
				+ favourite + ", favouriteMap=" + favouriteMap + ", contacts=" + contacts + "]";
	}

}
