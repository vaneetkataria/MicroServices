package com.katariasoft.microservices.movieservice.web.user.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class DefaultSystemUserConfiguration {

	private String name;
	private String clazz;
	private List<String> subjects;
	private Map<String, String> projects;
	private Credenetials credenetials;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Credenetials getCredenetials() {
		return credenetials;
	}

	public void setCredenetials(Credenetials credenetials) {
		this.credenetials = credenetials;
	}

	@Override
	public String toString() {
		return String.format(
				"DefaultSystemUserConfiguration [name=%s, clazz=%s, subjects=%s, projects=%s, credenetials=%s]", name,
				clazz, subjects, projects, credenetials);
	}

}
